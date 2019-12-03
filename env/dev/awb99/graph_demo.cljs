(ns awb99.graph-demo
(:require

  [awb99.d3.text-demo :refer [d3-text-demo]]
  [awb99.d3.circle-demo :refer [d3-circle-demo]]
  [awb99.graph.demo :refer [dagre-demo1]]
  ))



(enable-console-print!)



(defn run []
  (d3-text-demo "#test-text")
  (d3-circle-demo "#test-circle")
  (dagre-demo1)

)