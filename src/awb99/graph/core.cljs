(ns awb99.graph.core
  (:require
   ["graphlib-dot" :as dot]
  ; ["lodash" :as lodash]
   ["d3" :as d3]
   ["dagre-d3" :as dagre-d3]))



(defn create-graph
  "creates a dagre graph from dot notation"
  [dot-string]
  (.read dot dot-string))



(defn make
  []
  (let [Graph (aget dagre-d3 "graphlib" "Graph")
        g (Graph.)]
    (.setGraph g #js{"nodesep" 5
                     "edgesep" 10
                     "ranksep" 10})
    (.setDefaultEdgeLabel g (fn [x] #js{}))
    g))


(def layout! (aget dagre-d3 "layout"))


(defn- cfg-bb->dagre
  [bb]
  #js{"width" (:width bb)
      "height" (:height bb)
      "label" (str (:addr bb))})


(defn add-node!
  [g bb]
  (let [bb' (cfg-bb->dagre bb)]
    (.setNode g (aget bb' "label") bb')))


(defn add-edge!
  [g edge]
  (.setEdge g (str (:src edge)) (str (:dst edge)) #js{"type" (:type edge)}))


(defn- dagre-bb->cfg
  [bb]
  (let [x (get bb "x")
        y (get bb "y")
        w (get bb "width")
        h (get bb "height")]
    {:x (- x (/ w 2))
     :y (- y (/ h 2))
     :height h
     :width w
     :id (js/parseInt (get bb "label"))}))



(defn get-nodes
  [g]
  (map dagre-bb->cfg (vals (js->clj (aget g "_nodes")))))


(defn- dagre-point->cfg
  [point]
  {:x (get point "x")
   :y (get point "y")})


(defn- dagre-edge->cfg
  [edge]
  {:points (mapv dagre-point->cfg (get edge "points"))
   :type (get edge "type")})


(defn get-edges
  [g]
  (mapv dagre-edge->cfg (vals (js->clj (aget g "_edgeLabels")))))







(defn get-container []
  (let [svg (.select d3 "svg#graphSVG")
        _ (println "svg: " (.stringify js/JSON svg))
     ]
    svg))

(defn render [graph node]
  (let [render (new dagre-d3/render)
        svg (get-container)]
    (println "graph: " (.stringify js/JSON graph))
    (println "svg: " (.stringify js/JSON svg))
    (render svg graph)
    ))
