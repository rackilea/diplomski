<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!-- head, or anything You want -->
<script>
    function addBid(){
        var bidId = document.getElementById("bidId").value;
        // do whatever with bidId
    }
</script>

<input type="hidden" id="bidId" value="<c:out value=${containerIndexes[knownIndex]}" />    

<custom:tag onclick="addBid();" />