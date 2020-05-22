@NamedEntityGraph(
    name = "post",
    attributeNodes = {
        @NamedAttributeNode("title"),
        @NamedAttributeNode(value = "comments", subgraph = "comments")
    },
    subgraphs = {
        @NamedSubgraph(
                name = "comments",
                attributeNodes = {
                    @NamedAttributeNode("content")}
        )
    }
)