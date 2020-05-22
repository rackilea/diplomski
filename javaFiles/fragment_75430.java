<s:if test="%{bookResultList.size>0}">
  <table>
     <s:iterator value="bookResultList">
        <tr>      
          <td><s:property value="bookName"/></td>
          <td><s:property value="bookCost"/></td>                
       </tr>
    </s:iterator>
 </table>
 </s:if>
<s:else>
    <div> No data found</div>
</s:else>