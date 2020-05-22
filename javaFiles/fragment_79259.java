<c:forEach items="${rootCategories}" var="categoryLevel1">

    // ...

    <c:forEach items="${categoryLevel1.subCategories}" var="categoryLevel2">

        // ...

        <c:forEach items="${categoryLevel2.subCategories}" var="categoryLevel3">

            // ...  

        </c:forEach>

        // ...

    </c:forEach>

    // ...

</c:forEach>