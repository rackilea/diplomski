final ExpandSelectTreeNode node = ExpandSelectTreeNode.entitySet(entitySet).expandedLinks(Lists.newArrayList(<YOUR_NAVIGATION_PROPERTY>).build();
final EntityProviderWriteProperties properties = EntityProviderWriteProperties
                    .serviceRoot(new URI(this.serviceRoot + "/"))
                    .additionalLinks(toHuContent)
                    .expandSelectTree(node)
                    .build();