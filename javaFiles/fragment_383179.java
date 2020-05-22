task javadocJar(type: Jar) {
    classifier = 'javadoc'
    from javadoc
}   

artifacts {
    archives javadocJar
}