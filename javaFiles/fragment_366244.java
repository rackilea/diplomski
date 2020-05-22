<xp:repeat
    id="DriverRepeat"
    var="rowData"
    indexVar="rowIndex"
    value="#{javascript:requestBean.getDrivers()}">
    <xp:label value="#{rowData}" />
    <xp:inputText value="#{requestBean.driverChanges[rowIndex]}" />
    <br />
</xp:repeat>