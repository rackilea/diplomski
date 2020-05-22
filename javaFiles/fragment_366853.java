//Other class
ArrayList<GuestAgent> agents;
agents = Tenant.getTenantObject().gAgentList(new AgentsResultCallback {
    void onCompleted(ArrayList<GuestAgent> agents) {
        // here we have the result!
        if (agents != null) { // check for errors 
            Window.alert(Integer.toString(agents.size()));
        }
    }
});