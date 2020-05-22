<s:iterator value="themes" status="currentRecord"> 
   <s:if test="%{#session.usertheme.equalsIgnoreCase(themeName)}">
      <td align="center" bgcolor="red">
   </s:if>
   <s:else>
      <td align="center" bgcolor="yellow">
   </s:else>
....