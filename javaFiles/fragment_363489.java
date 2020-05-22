<c:choose>
      <c:when test="<%= themeDisplay.getScopeGroup().getName().equals("MyCustomCommunity_1") %>">
        <aui:script use="liferay-session">
            Liferay.Session.init(
              {
                autoExtend: false /*my custom value*/,
                timeout: 5 /*my custom value*/,
                timeoutWarning: 0 /*my custom value*/,
                redirectOnExpire: '/web/guest/mycustompage1' /*my custom value*/
              }
            );
        </aui:script>
      </c:when>
      <c:when test="<%= themeDisplay.getScopeGroup().getName().equals("MyCustomCommunity_2") %>">
        <aui:script use="liferay-session">
            Liferay.Session.init(
              {
                autoExtend: true /*my custom value*/,
                timeout: 15 /*my custom value*/,
                timeoutWarning: 1 /*my custom value*/,
                redirectOnExpire: '/web/guest/mycustompage2' /*my custom value*/
              }
            );
        </aui:script>
      </c:when>
      <c:otherwise>
        <aui:script use="liferay-session">
          Liferay.Session.init(
            {
              autoExtend: <%= PropsValues.SESSION_TIMEOUT_AUTO_EXTEND %>,
              timeout: <%= sessionTimeout %>,
              timeoutWarning: <%= sessionTimeoutWarning %>,
              redirectOnExpire: <%= PropsValues.SESSION_TIMEOUT_REDIRECT_ON_EXPIRE %>
            }
          );
        </aui:script>
      </c:otherwise>
    </c:choose>