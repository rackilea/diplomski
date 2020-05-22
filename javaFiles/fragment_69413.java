List<UserDefinedFunction> udfs = client.queryUserDefinedFunctions(
        myCollection.getSelfLink(),
        new SqlQuerySpec("SELECT * FROM root r WHERE r.id=@id",
                         new SqlParameterCollection(new SqlParameter("@id", myUdfId))),
        null).getQueryIterable().toList();
if (udfs.size() > 0) {
    // Found UDF.
}