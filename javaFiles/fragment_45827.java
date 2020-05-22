<s:iterator value="roleScreenDetailsList" status ="itemIndex">
   <table>
      <tr id="row_${itemIndex.count}">
         <td><s:textfield name="roleDescription" id="Desc_%{#itemIndex.count}" /></td>
      </tr>
   </table>
</s:iterator>