(ns wip.test)

; looks for wip/himplement.clj on the classpath, and compiles it into .class files
; requires that ../bin is in the classpath
(binding [*compile-path* "../bin"]
     (compile 'wip.himplement))

; loads the wip.himplement class from the .class files
(Class/forName "wip.himplement")


; create a list of all loaded classes (could presumably also be done with org.reflections)
(def classes-list (let [classloader (.getClassLoader clojure.main)
                        classes-field (.getDeclaredField java.lang.ClassLoader "classes")]
                    (.setAccessible classes-field true)
                    (java.util.ArrayList. (.get classes-field classloader))))

; Outputs all loaded classes which implement HInterface. Output is:
; (wip.hello.HInterface wip.himplement)
(println (filter #(isa? % wip.hello.HInterface) classes-list))