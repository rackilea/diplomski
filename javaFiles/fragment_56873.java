<c:forEach items="${map}" var="entry">
    Key="${entry.key}" Value=${entry.value}
</c:forEach>

URL Of This Page = ${map.urlOfThisPage }
URL Of That Page = ${map.urlOfThatPage }


URL Of This Page = ${map['urlOfThisPage'] }
URL Of That Page = ${map['urlOfThatPage'] }