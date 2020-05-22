<!--
    This acts as markingBean.getMarkSectionOne.getSpinnerField() when rendering
    and as markingBean.getMarkSectionOne.setSpinnerField(spinner.getValue()) when sending the request to the server
-->
<p:spinner id="ajaxspinner80-100" value="#{markingBean.markSectionOne.spinnerField}"
    stepFactor="1"  min="80" max="100" disabled="#{formBean.number != 8}">
    <p:ajax update="ajaxspinnervalue" process="@this" />
</p:spinner>