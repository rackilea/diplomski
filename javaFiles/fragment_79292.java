<bean id="outputFile"
    class="org.springframework.core.io.FileSystemResource" scope="step">
    <constructor-arg value="#{jobParameters[outputFile]}"></constructor-arg>
</bean>

<bean id="outputFileWriter"
    class="org.springframework.batch.item.file.FlatFileItemWriter">
    <property name="resource" ref="outputFile"></property>
    <property name="lineAggregator">
        <bean
            class="org.springframework.batch.item.file.transform.PassThroughLineAggregator">
        </bean>
    </property>
</bean>

<batch:step id="outputStep">
    <batch:tasklet>
        <batch:chunk commit-interval="10" reader="sectionFileReader"
            writer="outputFileWriter">
        <batch:streams>
            <batch:stream ref="sectionFileReader" />
            <batch:stream ref="trueSectionFileReader" />
        </batch:streams>
        </batch:chunk>
    </batch:tasklet>
</batch:step>

<batch:job id="iniJob">
    <batch:step id="step1" parent="outputStep"></batch:step>
</batch:job>