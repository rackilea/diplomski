<beans:bean id="outputFile"
class="org.springframework.core.io.FileSystemResyource" scope="step">
<beans:constructor-arg value="#{jobParameters[outputFile]}"/>
</beans:bean>
<beans:bean id="outputWriter"
class="org.springframework.batch.item.file.FlatFileItemWriter">
<beans:property name="resource" ref="outputFile" />
<beans:property name="lineAggregator">
<beans:bean class="org.springframework.batch.item.file.transform.
PassThroughLineAggregator"/>
</beans:property>
</beans:bean>