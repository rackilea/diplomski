function appender (str) {
    return function (s1) {
        str += s1
        return str
    }
}

jjs> var a1 = appender("foo")
jjs> var a2 = appender("bar")
jjs> a1("x")
foox
jjs> a1("y")
fooxy
jjs> a2("qq")
barqq