<div style="float: left;">
    <ui:repeat value="#{bean.list}" var="item" varStatus="loop">
        <h:outputText value="&lt;/div&gt;&lt;div style='float: left;'&gt;" escape="false" rendered="#{not loop.first and loop.index % 3 == 0}" />
        <div>#{item}</div>
    </ui:repeat>
</div>