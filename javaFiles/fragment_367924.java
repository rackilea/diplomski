// grails-app/domain/JobProcess.groovy
class JobProcess {
    User scriptUser
}

// grails-app/domain/User.groovy
class User {
    String name
}

// grails-app/conf/Bootstrap.groovy
def init = { servletContext ->
    def foo = new User(name: 'foo').save()
    def bar = new User(name: 'bar').save()
    new JobProcess(scriptUser: foo).save()
    new JobProcess(scriptUser: bar).save()
    new JobProcess(scriptUser: bar).save()

    def result = JobProcess.withCriteria {
        scriptUser {
            like('name', 'ba%')
        }
    }
    result.each {
        println "Result ID: ${it.id}"
    }

    // prints:
    // Result ID: 2
    // Result ID: 3
 }