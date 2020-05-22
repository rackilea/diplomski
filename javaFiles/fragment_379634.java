(with-open [in (java.util.zip.GZIPInputStream.
                (clojure.java.io/input-stream
                 "fox.txt.gz"))]
  (println "result:" (slurp in)))

;=>  result: the quick brown fox