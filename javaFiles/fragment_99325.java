class MyController {
    // you write an action like this...
    def someAction(String name, Integer age) {
        // your code here
    }

    // the Grails compiler generates this additional method...
    def someAction() {
        // do some stuff needed by the framework

        // ...

        // initialize parameters

        def name = ...
        def age = ...

        // call the original method
        someAction(name, age)
    }
}