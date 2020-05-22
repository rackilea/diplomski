<c:forEach var="user" items="${listpersons}">
<tr>
    <td><a href="#">${user.username}</a><!--  <span>Clients</span> --> </td>
    <td><a href="#">${user.email}</a></td>
    <td>
        <button class="btn btn-white btn-sm" data-toggle="tooltip" data-placement="top" title="Compose"><a href="#"><i class="fa fa-envelope-o"></i></a></button>
        <a href="${pageContext.request.contextPath}/edit?id=${user.id}&name=${user.username}&password=${user.password}&email=${user.email}"><i class="fa fa-edit" title="Edit"></i></a></button>
        <a href="${pageContext.request.contextPath}/delete?id=${user.id}" title="Delete"><i class="fa fa-trash-o"></i></a>
        <a href="#myModal_${user.id}" role="button" class="btn btn-large btn-primary" data-toggle="modal">Launch Demo Modal</a>
    </td>
    <td class="text-right mail-date">Jan 16</td>
</tr>

<div id="myModal_${user.id}" class="modal fade">
    <div class="modal-dialog">
        <div class="modal-content">
            <div class="modal-header">
                <button type="button" class="close" data-dismiss="modal" aria-hidden="true">&times;</button>
                <h4 class="modal-title">Confirm Delete</h4>
            </div>

            <div class="modal-body">
                <p>Are you sure you want to delete this user? </p>
            </div>
            <div class="modal-footer">

                <button type="button" class="btn btn-default" data-dismiss="modal">Close</button>
                <a href="${pageContext.request.contextPath}/delete?id=${user.id}" title="Delete"><i class="fa fa-trash-o"></i>Delete</a>
            </div>
        </div>
    </div>
</div>  
</c:forEach>