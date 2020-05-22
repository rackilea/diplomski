<xx:tree value="#{menu.tree}" var="item">
    <xx:treeNode level="0">
        <xx:treeNodeItem rendered="#{item.accepts(user.roles)}">
            <h3>#{item.name}</h3>
            <xx:insertTreeNodeChildren />
        </xx:treeNodeItem>
    </xx:treeNode>
    <xx:treeNode>
        <ul>
            <xx:treeNodeItem rendered="#{item.accepts(user.roles)}">
                <li>
                    <a href="#{item.url}">#{item.name}</a>
                    <xx:insertTreeNodeChildren />
                </li>
            </xx:treeNodeItem>
        </ul>
    </xx:treeNode>
</xx:tree>