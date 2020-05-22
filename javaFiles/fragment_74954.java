List<MaintenancePlan> = 
    new DefaultZCUSTOMODATASRVService()
        .getAllMaintenancePlan()
        .filter(MaintenancePlan.CALL_HORIZON.eq("xyz"))
        .select(MaintenancePlan.TO_CALL_HISTORY)
        .execute(erpConfig);