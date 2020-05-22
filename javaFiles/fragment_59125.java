val res = dataset.flatMap(line => {
    val f = line.split(":", -1) //taking care of the empty values with -1
    val keys = f(0).split(" ", -1)
    val values = f(2).split(" ", -1)
    keys.zip(values) //List[(String, String)], (key, value) pairs for a line
})

res.collect.map(println)

(1,3)
(2,2)
(3,1)
(4,2)
(5,1)
(2,1)
(3,2)
(5,1)
(4,1)
(5,2)