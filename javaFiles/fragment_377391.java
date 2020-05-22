<s:form method="POST" action="edit">
    <table border="4">
        <tbody>
            <s:iterator value="basket.items" var="item" status="ctr">
                <tr>
                    <td>
                        <s:textfield name="item[%{#ctr.index}].id" />
                    </td>
                    <td>
                        <s:textfield name="item[%{#ctr.index}].product.price" />
                    </td>
                </tr>
            </s:iterator>
        </tbody>
    </table> 
    <s:submit value="Edit"/>
</form>