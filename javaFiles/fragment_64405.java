task copyDependenciesNoSr(type: Copy) {
    from (configurations.compile){
        include 'a','b'
        exclude 'x','y'
    }
    into 'build/libs/nosr/lib'
}