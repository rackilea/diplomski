<rich:calendar value="#{oc.overtimeDate}" 
    requiredMessage="Date 1 is required."
    id="#{oc.overtimeDateId}" 
    binding="#{oc.calendarComponent}" 
    required="#{oc.id == 1}">
</rich:calendar>
<h:inputText value="#{oc.overtimeHours}" 
    id="#{oc.overtimeHoursId}"
    requiredMessage="Hours is required." 
    required="#{not empty oc.calendarComponent.value}" >
</h:inputText>