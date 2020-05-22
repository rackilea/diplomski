<netui-data:repeater dataSource="pageFlow.ld">
<netui-data:repeaterItem>
<netui:anchor value="${container.item.rd.name}" action="getCharts">
<netui:parameter name="id" value="${container.item.rd.id}"/>
</netui:anchor>
</netui-data:repeaterItem>
</netui-data:repeater>