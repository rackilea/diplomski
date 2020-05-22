import org.codehaus.groovy.grails.validation.routines.InetAddressValidator

...
String someIp = // some String
if(InetAddressValidator.getInstance().isValidInet4Address(someIp)){
    println "Valid Ip"
} else {
    println "Invalid Ip"
}
...