StoredProcedure sp = new StoredProcedure(ds, SQL) {
        public Object execute(String tableName) {
            Map in = new HashMap();
            in.put("param_in", tableName);
            Map out = execute(in);
            if (!out.isEmpty()) {
                return out.get("param_out");
            } else {
                return null;
            }
        }
    };