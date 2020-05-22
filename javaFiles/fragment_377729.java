<g:if test="${user?.hasErrors() || user.address?.hasErrors()}">
  <div class="errors">
    <g:hasErrors bean="${user}">
       <g:renderErrors bean="${user}" as="list" />
    </g:hasErrors>
    <g:hasErrors bean="${user?.address}">
       <g:renderErrors bean="${user?.address}" as="list" />
    </g:hasErrors>
  </div>
</g:if>