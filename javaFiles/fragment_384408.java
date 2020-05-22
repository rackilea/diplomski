SolverConfig solverConfig = new SolverConfig()
        .withEnvironmentMode(EnvironmentMode.REPRODUCIBLE)
        .withSolutionClass(VehicleRoutingSolution.class)
        .withEntityClasses(Standstill.class, PlanningVisit.class)
        .withScoreDirectorFactory(new ScoreDirectorFactoryConfig().withScoreDrls("org/optaweb/vehiclerouting/solver/vehicleRoutingScoreRules.drl"))
        .withTerminationConfig(new TerminationConfig().withSecondsSpentLimit(60L))
        .withPhases(
                new ConstructionHeuristicPhaseConfig().withConstructionHeuristicType(ConstructionHeuristicType.FIRST_FIT_DECREASING),
                new LocalSearchPhaseConfig().withLocalSearchType(LocalSearchType.TABU_SEARCH)
        );