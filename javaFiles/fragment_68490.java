<ui:repeat var="gtField" value="#{resBRRD_83_2_3_Bean.resolutionPowers_DD}">
    <h:panelGroup id="resolutionPower">
        <p:selectBooleanCheckbox itemLabel="#{gtField.tcdDesc}" value="#{gtField.selected}">
            <p:ajax type="change" process="@this" update="@this resolutionPower" />
        </p:selectBooleanCheckbox>
        <br />
        <p:inputText rendered="#{gtField.selected}" style="width:100%" />
        <p:spacer height="5px" rendered="#{gtField.selected}" />
        <br />
    </h:panelGroup>
</ui:repeat>