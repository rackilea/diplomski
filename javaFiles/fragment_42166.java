builder.configureStates()
            .withStates()
            .initial(SI)
            .state(F1, context -> context.getStateMachine().sendEvent(E2))
            .state(F2, context -> context.getStateMachine().sendEvent(E3))
            .end(SF);

    builder.configureTransitions()
            .withExternal().source(SI).target(F1).event(E1)
            .and()
            .withExternal().source(F1).target(F2).event(E2)
            .and()
            .withExternal().source(F2).target(SF).event(E3)
                .action(context -> System.out.println("Completing SM!"));