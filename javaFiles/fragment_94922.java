import grails.async.Promise
import static grails.async.Promises.task

Promise p = task {
    // do stuff
}
p.onError { Exception err ->
    log.error( "Error during task $err" )
}
p.onComplete {
    log.info "Task completed"
}