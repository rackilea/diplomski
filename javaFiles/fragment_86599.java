jar {
    manifest {
    attributes(
            'Implementation-Title': 'gscc-groupme-logs',
            'Implementation-Version': version
            'Class-Path': configurations.compile.collect { it.getName() }.join(' '),
            'Main-Class': 'GetGroupMeMessages'
    )        
    }
}