<s:select name="availableIds" list="%{#session.availableSupervisorsMap}" multiple="true">
  <s:optgroup label="key">
    <s:iterator value="value" var="currentRow">
        <option value="%{#currentRow.employeeId}">
            <s:property value="%{#currentRow.employeeName}"/>
        </option>
     </s:iterator>
   </s:optgroup>
</s:select>