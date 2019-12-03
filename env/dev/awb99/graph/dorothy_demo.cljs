(ns awb99.graph.dorothy-demo
  (:require 
   [dorothy.core :refer [digraph subgraph node-attrs dot]]))


(defn dorothy-demo []
  (dot
   (digraph 
    [(subgraph :cluster_0 [{:style :filled, :color :lightgrey, :label "process #1"}
                           (node-attrs {:style :filled, :color :white})
                           [:a0 :> :a1 :> :a2 :> :a3]])
     (subgraph :cluster_1 [{:color :blue, :label "process #2"}
                           (node-attrs {:style :filled})
                           [:b0 :> :b1 :> :b2 :> :b3]])
     [:start :a0]
     [:start :b0]
     [:a1    :b3]
     [:b2    :a3]
     [:a3    :a0]
     [:a3    :end]
     [:b3    :end]

     ;[:start {:shape :Mdiamond}]
     ;[:end   {:shape :Msquare}]
     ])))