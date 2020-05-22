(defn data->transfer2 [sql table]
     (jdbc/with-db-transaction [read-tx {:datasource dag-db}]
     (jdbc/with-db-transaction [tx {:datasource dct-db}]
        (jdbc/query read-tx
                  [(jdbc/prepare-statement (:connection read-tx)
                                           answer-sql
                                           {:result-type :forward-only
                                            :concurrency :read-only
                                            :fetch-size 100000})]
                  {:as-arrays? true
                   :result-set-fn (fn [result-set]
                                    (let [keys (first result-set)
                                          values (rest result-set)]
                                      (doseq [btch (partition-all 100000 values)]
                                        (jdbc/insert-multi! tx
                                                            :dim_answers
                                                             keys
                                                             btch))))})))