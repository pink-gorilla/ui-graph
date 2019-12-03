(ns awb99.graph.demo
  (:require
   ["dagre-d3" :as dagre-d3]
   [goog.dom :as gdom]
   [awb99.graph.core :refer [create-graph render]]
   [awb99.d3.text-demo :refer [d3-text-demo]]
   [awb99.d3.circle-demo :refer [d3-circle-demo]]
   [awb99.graph.dagre-demo :refer [demo-dagre]]))

(enable-console-print!)



(defn run []
  (d3-text-demo "#test-text")
  (d3-circle-demo "#test-circle")
 (println "graph-viz demo running")
  (let [dom-node "svg#dagre-demo" ;(.querySelector js/document "#dagre-demo")
        ;graph (demo-dagre)
        ;graph (create-graph "digraph { c -> b }")
        graph (create-graph "digraph { 1; 2; subgraph X { 3; 4 }; subgraph Y {} }")
        ]   
    (render dom-node graph)

    ))