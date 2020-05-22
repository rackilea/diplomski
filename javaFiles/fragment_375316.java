public class MySP extends StoredProcedure {
    private static final String PROC_NAME = "my.proc";

    public MySP(DataSource ds) {
        super(ds,PROC_NAME);

        //declaraction of parameters
        declareParameter(new SqlParameter("x", java.sql.Types.NUMERIC));
        declareParameter(new SqlOutParameter("y", java.sql.Types.VARCHAR));
        declareParameter(new SqlInOutParameter("z", java.sql.Types.VARCHAR));
    }
    public void execute() {
        Map<String, Object>  params = new HashMap<>();
        params.put("x", 89561L);
        params.put("y", 1L);
        params.put("z", 1L);

        super.execute(params);
    }

}