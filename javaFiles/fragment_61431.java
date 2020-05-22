<!-- ADDITIONAL ATTRIBUTES -->

<c:forEach items="${attributes}" var="a">

<div class="${a}">
    <span class="details_headline">${a}:</span>
    <input id="${a}" name="attributes[${a}]" class="input" type="text" value="" placeholder="${a}"/>
</div>

</c:forEach>

<!-- END ADDITIONAL ATTRIBUTES -->