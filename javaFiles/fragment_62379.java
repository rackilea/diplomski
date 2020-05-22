@Grab(group='org.codehaus.gpars', module='gpars', version='0.12')
import static groovyx.gpars.GParsExecutorsPool.withPool

withPool(50) {
    50.times {
        Closure callUrl = {"http://google.com".toURL().withReader {}}
        callUrl.callAsync();
    }
}