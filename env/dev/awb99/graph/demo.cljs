(ns awb99.graph.demo
  (:require
   ["dagre-d3" :as dagre-d3]
   [goog.dom :as gdom]
   [awb99.graph.core :refer [create-graph render]]
    [awb99.graph.dagre-demo :refer [demo-dagre]]
   ))



(defn dagre-demo1 []

  (let [ ;(.querySelector js/document "#dagre-demo")
        graph3 (demo-dagre)
        graph2 (create-graph "digraph { c -> b }")
        graph1 (create-graph "digraph { 1; 2; subgraph X { 3; 4 }; subgraph Y {} }")
        ]
    (render "svg#dagre-demo1" graph1)
    (render "svg#dagre-demo2" graph2)
    (render "svg#dagre-demo3" graph3)

    ))