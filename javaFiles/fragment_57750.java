<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ attribute name="path" required="true" %>


<input type="hidden" id="${path}" name="${path}" value="1" />
<input type="hidden" name="${path}_hashed" value="someHash" />