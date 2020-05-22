class ComplexSpec extends Specification {
    def 'we can ignore void methods in Spies'() {
        given:
        Complex complex = Spy()

        when:
        int result = complex.call('tim')

        then:
        result == 3
        1 * complex.sideEffect(_) >> null
        complex.sideEffects == []
    }
}