...
@Slf4j
class Family {
    static {
        new RollingFileAppender().with {
            name = 'file appender'
            file = 'C:\\tmp\\groovy.log'
            // the policy to roll files
            rollingPolicy = new TimeBasedRollingPolicy().with{
                context = LoggerFactory.getILoggerFactory()
                // file name pattern for the rolled files
                fileNamePattern = 'C:\\tmp\\groovy.%date{yyyy-MM-dd}.%i.log'
                // the maximum number of files to be keeped.
                maxHistory = 10
                timeBasedFileNamingAndTriggeringPolicy = new SizeAndTimeBasedFNATP().with{
                    context = LoggerFactory.getILoggerFactory()
                    // the max size of each rolled file
                    maxFileSize = '3MB'
                }
            }
            context = LoggerFactory.getILoggerFactory()
            encoder = new PatternLayoutEncoder().with {
                context = LoggerFactory.getILoggerFactory()
                pattern = "%date{HH:mm:ss.SSS} [%thread] %-5level %logger{35} - %msg%n"
                start()
                it
            }
            start()
            log.addAppender(it)
        }
    }

...