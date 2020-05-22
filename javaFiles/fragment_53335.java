<c:choose>
    <c:when test= "${request.getSession().getAttribute("userName").equals("Guest")}">
        <button class="btn" id="getCitizens" onclick="DoGuestAccess()" type="button">Guest Access</button>
    </c:when>
<c:otherwise>
    <button class="btn" id="getCitizens" onclick="DoUsersAccess()" type="button">User Access</button>
</c:otherwise>