{
    "configuration": {
        "name": "RollingConfig",
        "ThresholdFilter": { "level": "info" },
        "properties": {
            "property": {
                "name": "basePath",
                "value": "${env:log_dir}"
             }
        },
        "appenders": {
            "RollingFile": {
                "name": "debugFile",
                "fileName": "${basePath}my_main.log",
                "filePattern": "${basePath}my_main_%d{yyyyMMdd}.log.gz",
                "PatternLayout": { "pattern": "%d{yyyy-MM-dd HH:mm:ss} %-5p [%5T] %c{1}:%L - %m%n" },
                "Policies": {
                    "SizeBasedTriggeringPolicy": { "size": "10 MB" }
                },
               "DefaultRolloverStrategy": { "max": "10"  }
            },
            "RollingFile": {
                "name": "errorFile",
                "fileName": "${basePath}my_err.log",,
                "filePattern": "${basePath}my_err_%d{yyyyMMdd}.log.gz",
                "thresholdFilter": {
                    "level": "ERROR",
                    "onMatch": "ACCEPT",
                    "onMisMatch": "DENY"
                },
                "PatternLayout": { "pattern": "%d{yyyy-MM-dd HH:mm:ss} %-5p [%5T] %c{1}:%L - %m%n" },
                "Policies": {
                     "SizeBasedTriggeringPolicy": {  "size": "10 MB" }
                },
                "DefaultRolloverStrategy": {"max": "10"}
            }
        },
        "loggers": {
            "logger": {
                 "name": "mainLogger",
                 "level": "info",
                 "additivity": "false",
                 "appender-ref": [ 
                                 {"ref": "debugFile"}, 
                                 { "ref":"errorFile"}
                                 ]
            },
            "root": {
                "level": "info",
                 "appender-ref": [ 
                                 {"ref": "debugFile" }, 
                                 { "ref":"errorFile" }
                                 ]
             }
          }
       }
}