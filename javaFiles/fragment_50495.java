<rich:calendar value="#{oc.overtimeDate}" 
    requiredMessage="Date 1 is required."
    id="#{oc.overtimeDateId}" 
    binding="#{calendarComponent}" 
    required="#{oc.id == 1 ? true : false}">
</rich:calendar>
<h:inputText value="#{oc.overtimeHours}" 
    id="#{oc.overtimeHoursId}"
    requiredMessage="Hours is required." 
    required="#{not empty calendarComponent.value}" >
</h:inputText>