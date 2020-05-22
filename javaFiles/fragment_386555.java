<s:url var="editUrl" action="editHyper">
  <s:param name="Employee_id" value="%{#attr.row.Employee_id}" />
</s:url>

<s:url var="deleteUrl" action="delete">
  <s:param name="Employee_id" value="%{#attr.row.Employee_id}" />
</s:url>

<display:column title="Edit">
  <s:a href="%{#editUrl}">Edit</s:a>
</display:column>

<display:column title="Delete">
  <s:a href="%{#deleteUrl}">Delete</s:a>
</display:column>