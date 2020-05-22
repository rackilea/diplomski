public static Set<String> getRelations(Dataset<org.apache.spark.sql.Row> dataframe){
    LogicalPlan plan = dataframe.queryExecution().analyzed();

    return scala.collection.JavaConverters.seqAsJavaListConverter(plan.collectLeaves()).asJava()
    .stream()
    .map(logicalPlan -> {

        if(logicalPlan instanceof CatalogRelation){
            CatalogRelation catalogRelation = (CatalogRelation) logicalPlan;
            return catalogRelation.tableMeta().database() + "." + catalogRelation.tableMeta().identifier().table();
        }
        if(logicalPlan instanceof LogicalRelation){
            LogicalRelation logicalRelation = (LogicalRelation) logicalPlan;
            return logicalRelation.catalogTable().get().database() + "." + logicalRelation.catalogTable().get().identifier().table();
        }
        return "";
    }).collect(Collectors.toSet());
}