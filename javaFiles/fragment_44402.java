final EntityProviderWriteProperties properties = EntityProviderWriteProperties
                    .serviceRoot(new URI(this.serviceRoot + "/"))
                    .additionalLinks(toHuContent)
                    .expandSelectTree(node)
                    .callbacks(new ImmutableMap.Builder<String, ODataCallback>().put(<YOUR_NAVIGATION_PROPERTY>, new PopulateInlineEntry()).build())
                    .build();