handlers=1console.java.util.logging.ConsoleHandler, 2jsp.org.apache.juli.FileHandler, 3financials.org.apache.juli.FileHandler
.handlers=1a.java.util.logging.ConsoleHandler

jsp.level=ALL
jsp.handlers=2jsp.org.apache.juli.FileHandler
org.apache.jasper.level = FINE
org.apache.jasper.handlers=2jsp.org.apache.juli.FileHandler
org.apache.jsp.level = FINE
org.apache.jsp.handlers=2jsp.org.apache.juli.FileHandler

com.paypal.level=ALL
com.paypal.handlers=3financials.org.apache.juli.FileHandler

3financials.org.apache.juli.FileHandler.level=ALL
3financials.org.apache.juli.FileHandler.directory=${catalina.base}/logs
3financials.org.apache.juli.FileHandler.prefix=financials.

2jsp.org.apache.juli.FileHandler.level=ALL
2jsp.org.apache.juli.FileHandler.directory=${catalina.base}/logs
2jsp.org.apache.juli.FileHandler.prefix=jsp.

1console.java.util.logging.ConsoleHandler.level=FINE
1console.java.util.logging.ConsoleHandler.formatter = java.util.logging.SimpleFormatter