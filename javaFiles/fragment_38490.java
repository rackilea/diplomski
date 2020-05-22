(defn hello [name]
  (str "Hello, " name "!"))

(defn my-function[]
  (reify 
    java.util.function.Function
    (apply [this arg]
      (hello arg))))

;; then do (my-function) where you need to pass in a Function