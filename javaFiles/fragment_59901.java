<s:iterator value="struct" status="elemsStatus">
<tr>
<td><s:textfield name="struct[%{#elemsStatus.index}].name" value="%{name}" theme="simple"/></td>
    <td><s:textfield name="struct[%{#elemsStatus.index}].type" value="%{type}" theme="simple"/></td>
    <td><s:textfield name="struct[%{#elemsStatus.index}].length" value="%{length}" theme="simple"/></td>
    <td><s:textfield name="struct[%{#elemsStatus.index}].precision" value="%{precision}" theme="simple"/></td>
    <td><s:textfield name="struct[%{#elemsStatus.index}].usage" value="%{usage}" theme="simple"/></td>
    <td><s:textfield name="struct[%{#elemsStatus.index}].init" value="%{init}" theme="simple"/></td>
    </tr>
</s:iterator>