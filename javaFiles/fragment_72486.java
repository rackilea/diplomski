<ui:repeat value="#{listModel.listRows}" var="listRow" varStatus="loop">
    <tr class="#{loop.even ? 'even' : 'odd'}">
        <td>
            <h:selectBooleanCheckbox 
                id="foo" 
                value="#{listRow.rowSelected}" 
                disabled="#{detailModel.readOnly}" />
        </td>
        <ui:insert name="columnData"/>
    </tr>
</ui:repeat>