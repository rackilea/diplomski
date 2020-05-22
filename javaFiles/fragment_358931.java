compile('org.codehaus.generama:generama:1.2.4') {
    exclude(group: 'commons-discovery', module: 'commons-discovery')
    exclude(group: 'jdom', module: 'jdom')  
}
compile('jdom:jdom:1.0')
compile('commons-discovery:commons-discovery:0.2')