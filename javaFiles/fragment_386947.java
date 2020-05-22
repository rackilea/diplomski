(defn maslurp [url]
  (let [a (new java.io.BufferedReader
               (new java.io.InputStreamReader
                    (.getInputStream (doto (.openConnection (new java.net.URL url))
                                       (.setRequestMethod "GET")
                                       (.setDoOutput false) ; false for GET
                                       (.setUseCaches false)))))]
    (loop [r (.readLine a) s ""]
      (if (nil? r)
        s
        (recur (.readLine a) (clojure.string/join [s r]))))))


@(future (maslurp "https://www.google.com"))