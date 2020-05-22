public void log(){
    double tick = RunEnvironment.getInstance().getCurrentSchedule().getTickCount();
    Context context = RunState.getInstance().getMasterContext();

    Map<String,TableModel> models = new HashMap<String,TableModel>();

    // Create a tab panel for each agent layer
    for (Object agentType : context.getAgentTypes()){
        Class agentClass = (Class)agentType;

        JPanel agentPanel = AgentTableFactory.createAgentTablePanel(context.getAgentLayer(agentClass), agentClass.getSimpleName());

        if (agentPanel instanceof TablePanel){
            TableModel model = ((TablePanel)agentPanel).getTable().getModel();
            models.put(agentClass.getSimpleName(), model);

        }
    }

    SpreadsheetUtils.saveTablesAsExcel(models, new File("out-"+tick+".xlsx"));
}