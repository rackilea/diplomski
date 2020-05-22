package com.example

import grails.transaction.Transactional

@Transactional
class FooService {

    def serviceMethod() {
        serviceFoo()
        serviceBar()
    }

    def serviceFoo() {
        new Foo().save(flush: true, failOnError: true)
    }

    def serviceBar() {
        new Bar().save(flush: true, failOnError: true)
    }
}