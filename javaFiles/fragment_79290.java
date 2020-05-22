<bean id="inputFile" class="org.springframework.core.io.FileSystemResource"
    scope="step">
    <constructor-arg value="#{jobParameters[inputFile]}"></constructor-arg>
</bean>

<bean id="sectionFileReader"
    class="com.underdogdevs.springbatch.reader.IniFileItemReader">
    <property name="delegate" ref="trueSectionFileReader"></property>
</bean>
<bean id="trueSectionFileReader"
    class="org.springframework.batch.item.file.FlatFileItemReader">
    <property name="lineMapper">
        <bean
            class="org.springframework.batch.item.file.mapping.PatternMatchingCompositeLineMapper">
            <property name="tokenizers">
                <map>
                    <entry key="[*" value-ref="sectionLineTokenizer">
                    </entry>
                    <entry key="*" value-ref="propertyLineTokenizer"></entry>
                </map>
            </property>
            <property name="fieldSetMappers">
                <map>
                    <entry key="[*" value-ref="sectionFieldSetMapper">
                    </entry>
                    <entry key="*" value-ref="propertyFieldSetMapper">
                    </entry>
                </map>
            </property>
        </bean>
    </property>
    <property name="resource" ref="inputFile"></property>
</bean>

<bean id="sectionLineTokenizer"
    class="com.underdogdevs.springbatch.tokenizer.SectionLineTokenizer">
</bean>

<bean id="sectionFieldSetMapper"
    class="org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper">
    <property name="prototypeBeanName" value="section"></property>
</bean>

<bean id="section" class="com.underdogdevs.springbatch.domain.Section"
    scope="prototype">
</bean>

<bean id="propertyLineTokenizer"
    class="org.springframework.batch.item.file.transform.DelimitedLineTokenizer">
    <property name="delimiter" value="="></property>
    <property name="names" value="key,value"></property>
</bean>

<bean id="propertyFieldSetMapper"
    class="org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper">
    <property name="prototypeBeanName" value="property"></property>
</bean>

<bean id="property" class="com.underdogdevs.springbatch.domain.Property"
    scope="prototype">
</bean>