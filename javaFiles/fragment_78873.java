import spock.lang.Specification

class TestMeSpec extends Specification {

    def "my test"() {
        def b = Mock( ClassB ) {
            executeCommand( _, _ ) >> { c, e -> e.execute() }
        }
        def c = Mock( ClassC )
        def d = Mock( ClassD )

        def a = new ClassA( classB: b, classC: c, classD: d )

        when:
        a.update( 0, [ : ] )

        then:
        1 * d.update( 0, [ : ] )
    }
}

class ClassA {
    ClassB classB
    ClassC classC
    ClassD classD

    void update( final int a, final Map<String, Object> b ) {
        classB.executeCommand( classC.callToMethodInClassC(), new InterfaceE<Void>() {
            @Override
            Void execute() {
                classD.update( a, b )
            }
        } )
    }
}

class ClassB {
    void executeCommand( c, InterfaceE e ) {
        println "REAL CLASS B executCommand() METHOD RUNNING"
    }
}

class ClassC {
    def callToMethodInClassC() {}
}

class ClassD {
    void update( a, b ) {
        println "REAL CLASS D update() method called with $a and $b"
    }
}

interface InterfaceE<T> {
    T execute()
}