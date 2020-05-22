private static Map<String, Params> params = new HashMap<>();

public static void main(String[] args) {
    params.put("Approval", new Params(0,  1, "businessUnitId", "projectManagerId"));
    params.put("Query", new Params(1,  6, "empCode", "projectManagerId"));
}