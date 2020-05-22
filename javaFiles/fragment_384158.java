<rich:panel styleClass="shadow">
    ...
    <h:form style="float: right;">
      <h:outputText value="Skin:&#160;" />
      <h:selectOneMenu value="#{skinBean.skin}" id="skin-selector" onchange="submit()">
        <f:selectItem itemValue="DEFAULT" itemLabel="Default" />
        <f:selectItem itemValue="classic" itemLabel="Classic" />
        <f:selectItem itemValue="blueSky" itemLabel="Blue Sky" />
        <f:selectItem itemValue="deepMarine" itemLabel="Deep Marine" />
        <f:selectItem itemValue="emeraldTown" itemLabel="Emerald Town" />
        <f:selectItem itemValue="japanCherry" itemLabel="Japan Cherry" />
        <f:selectItem itemValue="ruby" itemLabel="Ruby" />
        <f:selectItem itemValue="wine" itemLabel="Wine" />
      </h:selectOneMenu>
    </h:form>
</rich:panel>