(ns javafx-examples-clj.login
  (:import (javafx.application Application)
           (javafx.stage Stage)
           (javafx.scene Scene)
           (javafx.scene.layout GridPane)
           (javafx.scene.text Text Font FontWeight)
           (javafx.scene.control Button TextField Label PasswordField)
           (javafx.event EventHandler ActionEvent)
           (javafx.geometry Pos Insets))
  (:gen-class
   :name clj.javafx.Login
   :extends javafx.application.Application))


(defn init-scenetitle []
  (let [scenetitle (Text. "Welcome")]
    (.setFont scenetitle (Font/font "Tahoma" FontWeight/NORMAL 20.0))
    scenetitle))

(defn init-grid-layout []
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
      (.add (PasswordField.) 1 2))
    grid))

(defn -start [this stage]
  (let [grid init-grid-layout]
    (doto stage
      (.setTitle "JavaFX in Clojure Welcome!")
      (.setScene (Scene. (grid) 300 250))
      (.show))))
