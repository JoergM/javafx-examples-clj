(ns javafx-examples-clj.login
  (:import (javafx.application Application)
           (javafx.stage Stage)
           (javafx.scene Scene)
           (javafx.scene.layout GridPane HBox)
           (javafx.scene.text Text Font FontWeight)
           (javafx.scene.control Button TextField Label PasswordField)
           (javafx.scene.paint Color)
           (javafx.event EventHandler ActionEvent)
           (javafx.geometry Pos Insets))
  (:gen-class
   :name clj.javafx.Login
   :extends javafx.application.Application))


(def action-target
  (Text.))

(def on-button-action
  (proxy [EventHandler] []
    (handle [^ActionEvent event]
      (doto action-target
        (.setFill Color/FIREBRICK)
        (.setText "Sign in button pressed")))))

(defn- init-button []
  (let [hbox (HBox. 10)
        button (Button. "Sign in")]
    (.setOnAction button on-button-action)
    (doto hbox
      (.setAlignment Pos/BOTTOM_RIGHT)
      (.. (getChildren) (add button)))
    hbox))

(defn- init-scenetitle []
  (let [scenetitle (Text. "Welcome")]
    (.setFont scenetitle (Font/font "Tahoma" FontWeight/NORMAL 20.0))
    scenetitle))

(defn- init-grid-layout []
  (let [grid (GridPane.)]
    (doto grid
      (.setAlignment (Pos/CENTER))
      (.setHgap 10)
      (.setVgap 10)
      (.setPadding (Insets. 25 25 25 25))
      (.add (init-scenetitle) 0 0 2 1)
      (.add (Label. "User Name:") 0 1)
      (.add (TextField.) 1 1)
      (.add (Label. "Password") 0 2)
      (.add (PasswordField.) 1 2)
      (.add (init-button) 1 4)
      (.add action-target 1 6))
    grid))

(defn -start [this stage]
  (doto stage
    (.setTitle "JavaFX in Clojure Welcome!")
    (.setScene (Scene. (init-grid-layout) 300 250))
    (.show)))
