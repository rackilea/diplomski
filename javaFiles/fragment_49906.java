buildscript {
        repositories.jcenter()
        dependencies {
                classpath 'commons-io:commons-io:2.4'
        }
}

task tail << {
        def tailer = new org.apache.commons.io.input.Tailer(
                "/tmp/mylog" as File,
                [handle: { String l -> println l }] as org.apache.commons.io.input.TailerListenerAdapter
        )
        try {
                tailer.run()
        }
        finally {
                tailer.stop()
        }
}