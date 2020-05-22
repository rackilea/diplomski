<rich:calendar value="#{bean.date}" styleClass="textBox" datePattern="dd-MMM-yyyy" required="false">
    <a4j:support event="onchanged" action="#{bean.onChangeDate}" ajaxSingle="true"/>
</rich:calendar>

<h:inputText value="#{bean.aString}"  styleClass="textBox">
    <a4j:support event="onchange" action="#{bean.onChangeText}"  ajaxSingle="true" />
</h:inputText>