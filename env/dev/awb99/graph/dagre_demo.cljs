(ns awb99.graph.dagre-demo
  (:require
   ["dagre-d3" :as dagre-d3]
   [goog.dom :as gdom]
   [awb99.graph.core :refer [make add-edge! add-node! get-nodes get-edges layout!]]))


(def states  ["CLOSED" "LISTEN" 
              ;"SYN RCVD"
              ;"CLOSING"
              ])


(defn demo-dagre
  []
  (let [g (make)]
   ; (map #(.setNode g % #js {:label %}) states)
    (-> g
        (.setNode "CLOSED" #js {:label "C"})
        (.setNode "LISTEN" #js {:label "L"})
        (.setEdge "CLOSED" "LISTEN" #js {:label "open"})
        (.setEdge "CLOSED" "LISTEN" #js {:label "open"}))
   ; (layout! g)
    ;{:nodes (get-nodes g)
    ; :edges (get-edges g)}
    ;g
    ))


