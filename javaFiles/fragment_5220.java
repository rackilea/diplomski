configurations {
    plugin
}

dependencies {
    plugin project(':plugin')
}

war {
    into('WEB-INF/lib') {
        duplicatesStrategy 'exclude'
        from configurations.plugin
    }
}