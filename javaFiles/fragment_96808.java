<c:forEach var="row" items="${requestScope.authorityuser}">
    <tr id="row_${row.id_authority}">
        <td class="...">${row.id_authority}</td>
        <td class="...">...</td>
        <td class="users"><c:forEach var="u" items="${row.sub_menu_user}">|${u}| </c:forEach></td>
        <td class="...">...</td>
        <td>
            <a href="#update" role="button" data-toggle="modal"
            class="update" id_update="${row.id_authority}"
            nama_authority="${row.nama_authority}" menu="${row.menu}" 
            sub_menu_user="${row.sub_menu_user}" sub_menu_monitoring="${row.sub_menu_monitoring}" 
                sub_menu_parameter="${row.sub_menu_parameter}"> <i class="icon-edit"></i> <spring:message code="edit" text="default text" />
            </a> ...
        </td>
    </tr>
</c:forEach>