final Map<String, Map<String, Object>> toHuContent = new ImmutableMap.Builder<String, Map<String, Object>>()
                    .put(<YOUR_NAVIGATION_PROPERTY>, new ImmutableMap.Builder<String, Object>().build())
                .build();

final EntityProviderWriteProperties properties = EntityProviderWriteProperties
                    .serviceRoot(new URI(this.serviceRoot + "/"))
                    .additionalLinks(toHuContent)
                    .build();