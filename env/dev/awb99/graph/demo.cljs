(ns awb99.graph.demo
  (:require
   ["dagre-d3" :as dagre-d3]
   [goog.dom :as gdom]
   [awb99.graph.core :refer [create-graph render]]
   [awb99.d3.text-demo :refer [d3-text-demo]]
   [awb99.d3.circle-demo :refer [d3-circle-demo]]
   [awb99.graph.dagre-demo :refer [demo-dagre]]))

(enable-console-print!)


; "digraph { 1; 2; subgraph X { 3; 4 }; subgraph Y {} }"

(defn demo-graph []
  (let [g (new dagre-d3/graphlib.Graph)
        g (.setGraph g {})]
    (.setNode g {:shape "rect"})))


(defn run []
  (d3-text-demo "#test-text")
  (d3-circle-demo "#test-circle")
 (println "graph-viz demo running")
  (let [dom-node (.querySelector js/document "#graph")
        graph (demo-dagre)
        ]
   
    ;(set! (.-innerHTML div-graph)
    (render graph dom-node)
   ; (render (create-graph "digraph { c -> b }") div-graph)

    ;)
    ))