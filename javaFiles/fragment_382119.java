(let [classloader (.getClassLoader clojure.main)
      classes-field (.getDeclaredField java.lang.ClassLoader "classes")]
  (.setAccessible classes-field true)
  (let [class-list (.get classes-field classloader)
        class-vec (reduce conj [] class-list)] ; copy everything into a new vector rather than working directly with the classloader's private field
    class-vec))