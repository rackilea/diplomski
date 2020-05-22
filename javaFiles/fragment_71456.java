handlers = ..., 5request-dumper.org.apache.juli.FileHandler
...
5request-dumper.org.apache.juli.FileHandler.level = FINEST
5request-dumper.org.apache.juli.FileHandler.directory = ${catalina.base}/logs
5request-dumper.org.apache.juli.FileHandler.prefix = request-dumper.
5request-dumper.org.apache.juli.FileHandler.formatter = org.apache.juli.VerbatimFormatter
org.apache.catalina.filters.RequestDumperFilter.level = INFO
org.apache.catalina.filters.RequestDumperFilter.handlers = 5request-dumper.org.apache.juli.FileHandler