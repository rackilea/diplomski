<bean id="transactionDataFileItemReader"
    class="org.springframework.batch.item.file.FlatFileItemReader"
    scope="step">
    <property name="resource"
        value="#{jobParameters['processPath']}" />
    <property name="lineMapper">
        <bean
            class="org.springframework.batch.item.file.mapping.DefaultLineMapper">
            <property name="lineTokenizer">
                <bean
                    class="org.springframework.batch.io.file.transform.FixedLengthTokenizer">
                    <property name="names" value="type,code" />
                    <property name="columns" value="1-12, 13-15" />
                </bean>
            </property>
            <property name="fieldSetMapper">
                <bean
                    class="org.springframework.batch.item.file.mapping.BeanWrapperFieldSetMapper">
                    <property name="prototypeBeanName" value="transactionMap" />
                </bean>
            </property>
        </bean>
    </property>
    <property name="linesToSkip" value="1" />
</bean>