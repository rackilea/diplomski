<c:forEach var="utente" items="${lista}">
    <tr>
        <td><c:out value="${utente.nome}"/></td>
        <td><c:out value="${utente.cognome}"/></td>
        <td><c:out value="${utente.posizione}"/></td>
        <td><c:out value="${utente.telefono}"/></td>
        <td>
           <img src="imm/view.png"/>&nbsp;
           <a href="" id="${utente.idUtente}" class="view">Vedi</a>
           &nbsp;&nbsp;
           <img src="imm/mod.png"/>&nbsp;
           <a href="<c:url value="InfoUtente">
                        <c:param name="id" value="${utente.idUtente}"/>
                    </c:url>" class="mod">Modifica</a>
           &nbsp;&nbsp;
           <img src="imm/del.png"/>&nbsp;
           <a href="" class="del" name="<c:out value="${utente.nome} ${utente.cognome}"/>">Elimina</a>
        </td>
    </tr>
</c:forEach>