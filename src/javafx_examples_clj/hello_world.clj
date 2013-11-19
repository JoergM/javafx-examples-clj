(ns javafx-examples-clj.hello-world
  (:import (javafx.application Application)
           (javafx.stage Stage)
           (javafx.scene Scene)
           (javafx.scene.layout StackPane)
           (javafx.scene.control Button)
           (javafx.event EventHandler ActionEvent))
  (:gen-class
   :name clj.javafx.HelloWorld
   :extends javafx.application.Application))

(defn init-button []
  (let [button (Button.)]
    (doto button
      (.setText "Say 'Hello World!'")
      (.setOnAction
       (proxy [EventHandler] []
         (handle [^ActionEvent event]
           (println "Hello World!")))))
    button))

(defn init-root-pane []
  (let [root (StackPane.)]
    (.. root (getChildren) (add (init-button)))
    root))

(defn -start [this stage]
  (doto stage
    (.setTitle "Hello World!")
    (.setScene (Scene. (init-root-pane) 300 250))
    (.show)))
