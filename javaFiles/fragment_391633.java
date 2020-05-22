library(rJava)
.jinit()

x <- .jnew("java/util/HashMap")
y <- .jnew("java/lang/Double", 3.14)
.jrcall(x, "put", "a", y)

x
[1] "Java-Object{{a=3.14}}"