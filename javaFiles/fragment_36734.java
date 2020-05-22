Formula name:
<h:inputText value="#{output.formulaName}" id="formulaName" />
<br/><br/>

The formula so far:
<h:inputTextarea id="formula" value="#{output.propertyReferenceValue}#{output.property2ReferenceValue}"></h:inputTextarea>
<br/><br/>

Property1:
<h:selectOneMenu value="#{output.propertyReferenceValue}" id="selectTwo">
    <f:selectItems value="#{property.propertyReference}"/>
    <f:ajax render="formula" />
</h:selectOneMenu>
<br/><br/>

Property2:         
<h:selectOneMenu value ="#{output.property2ReferenceValue}" id="selectThree">
    <f:selectItems value="#{property2.property2Refference}" />            
    <f:ajax render="formula" />
</h:selectOneMenu>