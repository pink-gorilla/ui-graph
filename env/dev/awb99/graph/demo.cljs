(ns awb99.graph.demo
  (:require
   [awb99.graph.core :refer [create-graph render]]
   
   [awb99.graph.dagre-demo :refer [demo-dagre]]
   [awb99.graph.dorothy-demo :refer [dorothy-demo]]))



(def gorilla-dot "
digraph  {
dpi=72;
rankdir=TB;
node [label=\"\" shape=\"rect\" penwidth=\"4\"]
edge [color=\"#555555\"]

subgraph root{
label=\" \";
 color=\"#666666\";
 fontsize=\"20\";
 
node1;
node3;
node6;
node14;
node16;
node17}
node1[label=\"Jupyter\" color=\"#666666\" height=\"1.2\" width=\"2\"];
node3[label=\"Gorilla Repl\" color=\"#666666\" height=\"1.2\" width=\"2\"];
node6[label=\"Pink Gorilla\" color=\"#D1686E\" height=\"1.2\" width=\"2\"];
node14[label=\"Clojure Kernel\" color=\"#666666\" height=\"1.2\" width=\"2\"];
node16[label=\"Clojurescript Kernel\" color=\"#666666\" height=\"1.2\" width=\"2\"];
node17[label=\"maven npm\" color=\"#666666\" height=\"1.2\" width=\"2\"];
node3->node6[label=\"\"];
node6->node14[label=\"\"];
node1->node3[label=\"\"];
node3->node3[label=\"\"];
node6->node16[label=\"\"];
node14->node16[label=\"\"];
node16->node14[label=\"\"];
node17->node16[label=\"\"];
node16->node17[label=\"\"];
node17->node14[label=\"\"];
node14->node17[label=\"\"];
node17->node17[label=\" \"];}")


(defn dagre-demo1 []

  (let [;(.querySelector js/document "#dagre-demo")
        graph1 (create-graph "digraph { 1; 2; subgraph X { 3; 4 }; subgraph Y {} }")
        graph2 (create-graph "digraph { c -> b }") 
        graph3 (demo-dagre)
        graph4 (create-graph (dorothy-demo))
        _ (println "dorothy graph: " graph4)
        graph5 (create-graph gorilla-dot)
        ]
    (render "svg#dagre-demo1" graph1)
    (render "svg#dagre-demo2" graph2)
    (render "svg#dagre-demo3" graph3)
    (render "svg#dagre-demo4" graph4)
     (render "svg#dagre-demo5" graph5)
    ))