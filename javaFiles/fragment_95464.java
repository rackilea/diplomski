(defn find-factory
  "Returns the first non-nil value from slf4j-factory, cl-factory,
   log4j-factory, and jul-factory."
  []
  (or (slf4j-factory)
      (cl-factory)
      (log4j-factory)
      (jul-factory)
      (throw ; this should never happen in 1.5+
        (RuntimeException.
          "Valid logging implementation could not be found."))))