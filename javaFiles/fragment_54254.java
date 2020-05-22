<c:forEach value="#{bean.albums}" var="album" varStatus="loop">
  <h:form>
    <h:commandLink id="next" value="proxima" action="#{bean.next}">
      <f:param name="id" value="#{loop.index}" />
    </h:commandLink>
  </h:form>
</c:forEach>