(ns awb99.graph.dagre-demo
  (:require
   ["dagre-d3" :as dagre-d3]
   [goog.dom :as gdom]
   [awb99.graph.core :refer [new-graph add-edge! add-node! get-nodes get-edges layout!]]))



;; https://jsfiddle.net/f4pahbme/8/
;; https://dagrejs.github.io/project/dagre-d3/latest/demo/shapes

(defn demo-dagre
  []
  (let [g (new-graph)]
   ; (.setNode g "A" #js {:label "A" :rx 5 :ry 5})
   ; (.setNode g "B" #js {:label "B" :rx 5 :ry 5})
        ;(.setEdge "CLOSED" "LISTEN" #js {:label "open"})
        ;(.setEdge "CLOSED" "LISTEN" #js {:label "open"})
    g))


