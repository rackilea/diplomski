List<MaintenancePlan> result = 
      new DefaultZCUSTOMODATASRVService()
          .getAllMaintenancePlan()
          .filter(MaintenancePlan.CALL_HORIZON.eq("xyz"))
          .select(MaintenancePlan.TO_CALL_HISTORY
                  .select(MaintenancePlanCallHistory.INDICATOR,
                          MaintenancePlanCallHistory.MAINTENANCE_PLAN
                   )
           )
           .execute(erpConfig);