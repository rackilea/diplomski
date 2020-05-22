<ul>
<c:forEach var="grp"  items="${Group}">
            <li>
                 ${grp}

                 <ul>
                      <c:forEach var="pers"  items="${Person}">
                          <li>
                               ${pers}

                                ect...
                          </li>
                       </c:forEach>
                 </ul>
            </li>
        </c:forEach>
</ul>