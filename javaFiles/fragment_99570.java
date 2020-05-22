<tbody>
        <!-- each item in field will be an 1d array -->
        <c:forEach items="${field}" var="row">
            <td> |
                <tr class="your_class">
                <!-- each item in row will be an element -->
                <c:forEach items="${row}" var="item">
                    ${item} |
                </c:forEach>
                </tr>
            </td>
        </c:forEach>
    </tbody>
</table>