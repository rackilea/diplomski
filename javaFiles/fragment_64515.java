<g:each var="v" in="${visit.pet.visits}">
    <g:if test="${v.id}">
        <tr>
            <td><g:formatDate date="${v.date}" format="yyyy-MM-dd"/></td>
            <td>${v.description}</td>
        </tr>
    </g:if>
</g:each>