<form:form method="POST" modelAttribute="poem"
    action="${pageContext.request.contextPath}/poem/add.html">
    <table>
        <tbody>
            <tr>
                <td>Title:</td>
                <td><form:input path="poem.title" title="Your poem's title" 
                    type="text" class="input" /></td>
            </tr>
            <tr>
                <td>Author:</td>
                <td><form:input path="poem.author.name" title="Author's name"
                    type="text" class="input" /></td>
            </tr>
            <tr>
                <td>Text:</td>
                <td><form:textarea path="poem.body" title="Your poem goes here" rows="15" cols="50"
                        class="input" /></td>
            </tr>
        </tbody>
    </table>
    <table class="actions">
        <tr>
            <td><a
                href="${pageContext.request.contextPath}/collection.html"><input
                    type="button" value="Back" class="button" /></a></td>
            <td><a
                href="${pageContext.request.contextPath}/collection.html"><input
                    type="submit" value="Submit" class="button" /></a></td>
        </tr>
    </table>
</form:form>