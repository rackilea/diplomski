<%
    java.util.Properties pro = new java.util.Properties();
    pro.put("log4j.appender.A1.Threshold","INFO");
    pro.put("log4j.appender.A1","org.apache.log4j.RollingFileAppender");
    pro.put("log4j.appender.A1.File","/var/log/h3cloud.log");
    pro.put("log4j.appender.A1.MaxFileSize","100000KB");
    pro.put("log4j.appender.A1.MaxBackupIndex","5");