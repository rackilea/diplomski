Map<String, Object> out = jdbcCall.execute(in);
ArrayList obj = (ArrayList) out.get("RET_CURSOR");
logger.info("Length of retrieved routes from database = " + obj.size());
for (Object o : obj) {
    Map<String, Object> map = (Map<String, Object>) o;
    for (Map.Entry<String, Object> entry : map.entrySet())
        routes.add(entry.getValue().toString());
}