appenders {
    file name:'infoLog', file:'info.log', threshold: org.apache.log4j.Level.INFO
    file name:'warnLog', file:'warn.log', threshold: org.apache.log4j.Level.WARN
    file name:'errorLog', file:'error.log', threshold: org.apache.log4j.Level.ERROR
}

root {
    info 'infoLog','warnLog','errorLog'
}