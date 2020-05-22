(with-open [in (java.util.zip.InflaterInputStream.
                (clojure.java.io/input-stream
                 "balloon.txt.z"))]
  (println "result:" (slurp in)))

;=> result: the big red baloon