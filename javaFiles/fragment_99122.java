<table>
    <c:forEach begin="1" end="10" varStatus="status">
        <tr>
            <td>
                <c:forEach begin="1" end="${status.index}">
                    John&nbsp;
                </c:forEach>
                Value of k: ${status.index}
            </td>
        </tr>
    </c:forEach>
</table>