<RollingFile name="RollingFile" fileName="D:/app.log"
                     filePattern="D:/app-%d{yyyy-MM-dd-HH-mm-ss}.log">
            <PatternLayout>
                <Pattern>%d %p %c{1.} [%t] %m%n</Pattern>
            </PatternLayout>
            <Policies>
                <TimeBasedTriggeringPolicy interval="60" modulate="true"/>
                <!--<SizeBasedTriggeringPolicy size="250 MB"/>-->
            </Policies>
            <DefaultRolloverStrategy>
                <Delete basePath="D:" maxDepth="1">
                    <IfFileName glob="app-*.log" />
                    <IfLastModified age="3m" />
                </Delete>
            </DefaultRolloverStrategy>
        </RollingFile>