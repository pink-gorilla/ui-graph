(ns awb99.graph.demo
  (:require
   [awb99.graph.core :refer [create-graph render]]
   
   [awb99.graph.dagre-demo :refer [demo-dagre]]
   [awb99.graph.dorothy-demo :refer [dorothy-demo]]))



(defn dagre-demo1 []

  (let [;(.querySelector js/document "#dagre-demo")
        graph1 (create-graph "digraph { 1; 2; subgraph X { 3; 4 }; subgraph Y {} }")
        graph2 (create-graph "digraph { c -> b }") 
        graph3 (demo-dagre)
        graph4 (create-graph (dorothy-demo))
        _ (println "dorothy graph: " graph4)
        ]
    (render "svg#dagre-demo1" graph1)
    (render "svg#dagre-demo2" graph2)
    (render "svg#dagre-demo3" graph3)
    (render "svg#dagre-demo4" graph4)
    ))