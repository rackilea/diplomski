import groovy.transform.CompileStatic

@CompileStatic
class Static {

}

class Dynamic {

}

println Static.declaredMethods.length
Static.declaredMethods.collect { it.name }.each { println it }

println('-' * 100)

println Dynamic.declaredMethods.length
Dynamic.declaredMethods.collect{ it.name }.each { println it }