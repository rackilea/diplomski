List<ViolationSummaryDTO> result = em.createQuery(
                "SELECT new ViolationSummaryDTO(v.counName, v.siteNumber," +
                    "sum(case when v.pvClStati.clstId = 1 then 1 else 0 end) as suspectedViolation," +
                    "sum(case when v.pvClStati.clstId = 2 then 1 else 0 end) as confirmedViolation," +
                    "sum(case when v.pvClStati.clstId = 3 then 1 else 0 end) as confirmedNoViolation," +
                    "sum(case when v.pvClStati.clstId = 0 then 1 else 0 end) as notDetermined," +
                    "COUNT(*) as total)" +
                " FROM Violation v" +
                " WHERE v.trial.id = " + trialId +
                " GROUP BY v.counName, v.siteNumber", ViolationSummaryDTO.class).getResultList();