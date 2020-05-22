boolean checkBothApps = false;

org.jooq.SelectJoinStep<R> joinStep =  select(field("q.*"))
                        .from(table("QUEUES q"));

org.jooq.SelectConditionStep<R> conditionStep = joinStep.where(field("q.APPLICATION").eq("APP1"));

if (checkBothApps) {
  // This condition will be added to the join step.
  joinStep.or(field("q.APPLICATION").eq("APP2"));
}