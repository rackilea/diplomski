class GroovyWrapper extends groovy.util.Proxy {
    def wrapped
    GroovyWrapper(obj) {
        wrapped = obj
        adaptee = obj
    }
    def getProperty(String name) {
        wrapped.getProperty()
    }
}

def h = new GroovyWrapper(new HasProperty())
assert h.name == "pie"