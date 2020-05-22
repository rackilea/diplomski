<userTask id="alfrescoUsertask1" name="taskName" activiti:assignee="${initiator.properties.userName}" activiti:formKey="wfRepromaq:analisarCredito">
     <extensionElements>
         <activiti:taskListener event="complete" class="org.alfresco.repo.workflow.activiti.tasklistener.ScriptTaskListener">
            <activiti:field name="script">
                <activiti:string>   <![CDATA[execution.setVariable('wfRepromaq_ObsAnaliseCredito', task.getVariable('wfRepromaq_ObsAnaliseCredito'));]]></activiti:string>
            </activiti:field>
        </activiti:taskListener>
  </extensionElements>
</userTask>
 ...