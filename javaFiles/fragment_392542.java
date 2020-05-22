@NamedEntityGraph(
  name = "entity-with-all-relations",
  attributeNodes = {
    @NamedAttributeNode("relation1"),
    @NamedAttributeNode("relation2"),
  },