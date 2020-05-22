try (Transaction tx = getDatabase().beginTx()) {
    GraphDatabaseService database = getDatabase();

    Node rootProduct = database.findNode(DynamicLabel.label("Product"), "id", 1);

    int sum = getChildrenSum(rootProduct);

    rootProduct.setProperty("costs", sum);

    tx.success();
}

public int getChildrenSum(Node product) {
    int sum = 0;

    final DynamicRelationshipType relationshipType = DynamicRelationshipType.withName("COSTS");
    final Direction direction = Direction.OUTGOING;

    if (product.hasRelationship(relationshipType, direction)) {
        for (Relationship costs : product.getRelationships(relationshipType, direction)) {
            final Node child = costs.getEndNode();
            final String propertyName = "amount";

            if (child.hasProperty(propertyName)) {
                sum += Integer.parseInt(child.getProperty(propertyName).toString());
            }
            childrenSum += getChildrenSum(child);

            sum += childrenSum;

            child.setProperty("costs", childrenSum);
        }
    }

    return sum;
}