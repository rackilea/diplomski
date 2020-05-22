package com.example

import grails.test.mixin.integration.Integration
import grails.transaction.*
import spock.lang.*
import org.springframework.beans.factory.annotation.Autowired

@Integration
@Rollback
class TransactionIntSpec extends Specification {

    @Autowired
    FooService service

    void "test transaction rollback"() {
        given: 'bar service throws exception'
        service = Mock(FooService) {
            serviceBar() >> { throw new Exception() }
        }

        when:
        service.serviceMethod()

        then:
        !Foo.count() && !Bar.count()
    }

    void "test transaction successfull"() {
        when:
        service.serviceMethod()

        then:
        Foo.count() && Bar.count()
    }
}