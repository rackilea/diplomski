ser=> (into [] (java.util.ArrayList. [1 2 3]))
[1 2 3]
user=> (into #{} (java.util.HashSet. #{1 2 3}))
#{1 2 3}
user=> (into '() (java.util.LinkedList. '(1 2 3)))
(3 2 1)
user=> (into {} (java.util.HashMap. {:a 1 :b 2}))
{:b 2, :a 1}