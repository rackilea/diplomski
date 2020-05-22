<c:forEach var="e" items="${requestScope['listeEtablissement']}">  
        <c:if test="${e.id == X}">             
            <option value="${e.id}" selected>${e.libelle_etab}</option>
        </c:if>   
         <c:if test="${eid != X}">             
            <option value="${e.id}">${e.libelle_etab}</option>
        </c:if>    
    </c:forEach>           
</select>