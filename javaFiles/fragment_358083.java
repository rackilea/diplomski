public class CheckStatusCallable implements Callable<WorkerDTO> {

    private Connection connection;
    private String email;

    public CheckStatusCallable(Connection connection, String email) {
        this.connection = connection;
        this.email = email;
    }

    @Override
    public WorkerDTO call() throws Exception {
        Command objCmd = new Command();
        Recordset RS = new Recordset();
        objCmd.setActiveConnection(conn);
        String searchKeyword = "contractstatus";
        objCmd.setCommandText("XXX:LDAP_CONN)(mail=" + this.email + "));" + searchKeyword + ";subTree");

        RS = objCmd.Execute();
        WorkerDTO workerDTO = new WorkerDTO();
        workerDTO.setEmail(this.email);
        workerDTO.setEmail(e);
        if (RS.getBOF()) workerDTO.setStat("Not in SCD");
        else {
            RS.MoveFirst();
            Variant value = RS.getFields().getItem(0).getValue();

            if (value.getString().equals("R")) workerDTO.setStat("Retired");
            else if (value.getString().equals("A")) workerDTO.setStat("Active");
            else if (value.getString().equals("null")) workerDTO.setStat("Not in SCD");
        }
        return workerDTO;
    }
}