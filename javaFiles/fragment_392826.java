<af:selectOneChoice value="#{bindings.item_emp_id.inputValue}"
                    label="#{bindings.item_emp_id.label}"
                    required="#{bindings.item_emp_id.hints.mandatory}"
                    shortDesc="#{bindings.item_emp_id.hints.tooltip}"
                    id="soc3"  autoSubmit="true"
                    valueChangeListener="#{bean1.changeVal}">
  <f:selectItems value="#{bindings.item_emp_id.items}" id="si3"/>
</af:selectOneChoice>