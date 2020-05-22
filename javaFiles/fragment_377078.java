class SomeService {
    static transactional = false //service cannot be transactional

    private Object someLock = new Object() //synchronized block on some object must be used

    def someConcurrentSafeMethod(){
        synchronized(someLock){
            def person = Person.findByEmail(nperson.email.toLowerCase())
            ...
            person.save(flush: true) // flush is very important, must be done in synchronized block
        }
    }
}