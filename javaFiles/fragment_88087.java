TraversalDescription desc = Traversal.description()
        .uniqueness(Uniqueness.RELATIONSHIP_GLOBAL)
        .evaluator(Evaluators.returnWhereEndNodeIs(graphDb.getNodeById(12)))
        .evaluator(Evaluators.includingDepths(3, 3))
        .relationships(RelTypes.husband_of)
        .relationships(RelTypes.wife_of)
        .relationships(RelTypes.brother_of)
        .relationships(RelTypes.elti_of);

Traverser traverse = desc.traverse(graphDb.getNodeById(4), graphDb.getNodeById(12));