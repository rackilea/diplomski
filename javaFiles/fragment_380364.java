ProcessBuilder processBuilder = new ProcessBuilder(
                javaBin,
                "-cp",
                classpath,
                "-Djava.endorsed.dirs=" + "/Users/xxx/dev/src/gitlab/xxx/myapp/target/classes/lib/endorsed",
                "-Drrc.home=/private/var/tmp/myapp",
                "-Drrc.log.dir=/private/var/tmp",
                "-Drrc.env=/Users/xxx/dev/src/gitlab/xxx/myapp/target/classes/etc/examples/environment-apa.sh",
                "-Dsimplelogger.properties=/private/var/tmp/myapp/etc/simplelogger.properties ",
                "-server",
                "-XX:CompileThreshold=2500",
                "-XX:+UseFastAccessorMethods",
                "-Xss256k",
                "-Xmx1g",
                "-Xms512m",
                className
        );