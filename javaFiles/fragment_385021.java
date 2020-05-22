<configuration>
    <appender name="STDOUT" class="ch.qos.logback.core.ConsoleAppender">
        <encoder class="ch.qos.logback.core.encoder.LayoutWrappingEncoder">
            <layout class="rpost.MyPatternLayout">
                <pattern>%date{HH:mm:ss.SSS} [%t] %-5p %c{40}:%L - %m%n</pattern>
                <test>value 1</test>
                <test>value 2</test>
            </layout>
        </encoder>
    </appender>

    <root level="INFO">
        <appender-ref ref="STDOUT"/>
    </root>
</configuration>