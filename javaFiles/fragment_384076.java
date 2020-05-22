<ui:decorate template="mytemplate.xhtml">
  <ui:define name="pagecanonical">
    <s:link id="canonical" view="/rewriteSearchLink/resultsPage.xhtml" propagation="none">
      <f:param name="searchString" value="#{currentSearch.searchString}"/>
      <f:param name="placeString" value="#{currentSearch.placeString}"/>
      <f:param name="currentPage" value="#{currentSearch.currentPage}"/>
    </s:link>
  </ui:define>
</ui:decorate>