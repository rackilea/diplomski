<beans:bean id="customerFile"
class="org.springframework.core.io.FileSystemResyource" scope="step">
<beans:constructor-arg value="#{jobParameters[customerFile]}"/>
</beans:bean>
<beans:bean id="customerFileReader"
class="com.apress.springbatch.chapter7.CustomerFileReader">
<beans:property name="delegate" ref="trueCustomerFileReader"/>
</beans:bean>
<beans:bean id="trueCustomerFileReader"
class="org.springframework.batch.item.file.FlatFileItemReader">
<beans:property name="resource" ref="customerFile" />
<beans:property name="lineMapper">
<beans:bean class="org.springframework.batch.item.file.mapping.
PatternMatchingCompositeLineMapper">
<beans:property name="tokenizers">
<beans:map>
<beans:entry key="CUST*" value-ref="customerLineTokenizer"/>
<beans:entry key="TRANS*" value-ref="transactionLineTokenizer"/>
</beans:map>
</beans:property>
<beans:property name="fieldSetMappers">
<beans:map>
<beans:entry key="CUST*" value-ref="customerFieldSetMapper"/>
<beans:entry key="TRANS*" value-ref="transactionFieldSetMapper"/>
</beans:map>
</beans:property>
</beans:bean>
</beans:property>
</beans:bean>
<beans:bean id="customerLineTokenizer"
class="org.springframework.batch.item.file.transform.
DelimitedLineTokenizer">
<beans:property name="names" value="prefix,firstName,middleInitial,
lastName,address,city,state,zip"/>
<beans:property name="delimiter" value=","/>
</beans:bean>
<beans:bean id="transactionLineTokenizer"
class="org.springframework.batch.item.file.transform.DelimitedLineTokenizer">
<beans:property name="names"
value="prefix,accountNumber,transactionDate,amount"/>
<beans:property name="delimiter" value=","/>
</beans:bean>
<beans:bean id="customerFieldSetMapper"
class="org.springframework.batch.item.file.mapping.
BeanWrapperFieldSetMapper">
<beans:property name="prototypeBeanName" value="customer"/>
</beans:bean>
<beans:bean id="transactionFieldSetMapper"
class="com.apress.springbatch.chapter7.TransactionFieldSetMapper"/>
<beans:bean id="customer" class="com.apress.springbatch.chapter7.Customer"
scope="prototype"/>