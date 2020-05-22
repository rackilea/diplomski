JsonNode readTree = mapper.readTree(body);

for (JsonNode node : readTree.findPath("items")) {
    System.out.println(node.findPath("images").get(2));
    System.out.println(node.findPath("preview_url"));
}