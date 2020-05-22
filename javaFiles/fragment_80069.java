public class MyClassSpec extends Specification {
    def "check that the right messages are produced with the expected object"() {
        given:
        def messageService = Mock(IMessageService)
        def testedInstance = new MyClass()

        testedInstance.setMessageService(messageService)

        when:
        testedInstance.process()

        then:
        1 * messageService.produceMessageOne(_)
        1 * messageService.produceMessageTwo(_)
    }
}