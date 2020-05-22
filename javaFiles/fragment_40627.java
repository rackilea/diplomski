final Set<String> x = g.V(a).outE().label().toSet();
final Map<String, Long> m = g.withSideEffect("x", x).V(b).outE().as("e").label().as("l")
        .where(select("x").unfold().as("l"))
        .store("matchedQues").by(constant(1))
        .constant(a).outE().where(label().as("l")).inV().as("a1")
        .select("e").inV().as("a2").filter(select("a1", "a2").by("ans").where("a1", eq("a2")))
        .aggregate("matchedAns").by(constant(1)).cap("matchedAns", "matchedQues")
        .<Long>select("matchedAns", "matchedQues").by(count(local)).next();
return (m.get("matchedAns") * 100) / m.get("matchedQues");