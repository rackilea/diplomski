public void deploy (GridServiceManager gsm, String tenantName) {

    gsm.deploy(
            new ElasticStatefulProcessingUnitDeployment("/myproject/datagrid-persistency")
            .name(tenantName))

}