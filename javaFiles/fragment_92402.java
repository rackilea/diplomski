<c:forEach var="i" begin="0" end="${Data.getH().size() - 1}">
        <TR>
            <td>
             <input type="radio" name="xxxx" value="some value">some value
             </td>
            <TD>
                    ${Data.getH().get(i)}
            </TD>
            <TD>
                    ${Data.getM().get(i)}
            </TD>
            <TD>
                    ${Data.getV().get(i)}
            </TD>
                 </TR>
    </c:forEach>