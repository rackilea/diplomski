jar {
    manifest {
        attributes 'Implementation-Title': 'myapp', 'Implementation-Version': version,
        'Class-Path': configurations.runtime.files.collect { it.name }.join(' lib/') + ' lib/log4j.properties',
    'Main-Class': 'ca.company.product.myapp.Application',
    'Built-By': System.getProperty('user.name'),
    'Built-JDK': System.getProperty('java.version')
}