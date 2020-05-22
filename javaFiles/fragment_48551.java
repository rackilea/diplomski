<ul>
    <ui:repeat value="#{menu.list}" var="item">
        <ui:fragment rendered="#{item.accepts(user.roles)}">
            <li><a href="#{item.url}">#{item.name}</a></li>
        </ui:fragment>
    </ui:repeat>
</ul>