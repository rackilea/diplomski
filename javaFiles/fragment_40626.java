public static double matchability(GraphTraversalSource g, Vertex a, Vertex b) {
    return g.withSack(0).V(a).outE().aggregate("x").by(label).limit(1)
            .V(b).outE().as("e").label().as("l").where(select("x").unfold().as("l"))
            .store("matchedQues").by(constant(1))
            .V(a).outE().where(label().as("l")).inV().as("a1")
            .select("e").inV().as("a2").where("a1", eq("a2")).by("ans")
            .aggregate("matchedAns").limit(1)
            .sack(assign).by(select("matchedAns").count(Scope.local))
            .sack(mult).by(constant(100))
            .sack(div).by(select("matchedQues").count(Scope.local)).<Long>sack()
            .tryNext().orElse(0L);
}