logging:
  # The default level of all loggers. Can be OFF, ERROR, WARN, INFO, DEBUG, TRACE, or ALL.
  level: INFO

  loggers:
    "EVENT" : INFO

  loggerMapping:
    # for easier search this is defined as: appenderName -> loggerName rather than the other way around
    "eventLog" : "EVENT"

  appenders:
   - type: console   
     threshold: ALL
     logFormat: "myformat"

   - type: hostnameFile # NOTE THE NEW TYPE WITH HOSTNAME RESOLVE
     currentLogFilename: /Users/artur/tmp/log/my-${HOSTNAME}.log
     threshold: ALL
     archive: true
     archivedLogFilenamePattern: mypattern
     archivedFileCount: 31
     timeZone: UTC
     logFormat: "myFormat"

   - type: hostnameFile
     name: eventLog # NOTE THE APPENDER NAME
     currentLogFilename: something
     threshold: ALL
     archive: true
     archivedLogFilenamePattern: something
     archivedFileCount: 31
     timeZone: UTC
     logFormat: "myFormat"

   - type: hostnameFile
     currentLogFilename: something
     threshold: ERROR
     archive: true
     archivedLogFilenamePattern: something
     archivedFileCount: 31
     timeZone: UTC
     logFormat: "myFormat"