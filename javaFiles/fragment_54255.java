<ui:repeat value="#{bean.albums}" var="album">
  <h:form>
    <h:commandLink id="next" value="proxima" action="#{bean.next}">
      <f:param name="id" value="#{album.id}" />
    </h:commandLink>
  </h:form>
</ui:repeat>