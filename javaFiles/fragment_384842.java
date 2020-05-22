(defn expensivefunction [v x]
  (/ (reduce * v) x))


(let [v [1 2 3 4 5]]
  (map (partial expensivefunction v) v)) ; pmap would work equally well here!