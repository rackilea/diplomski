try
    {
        /*
         * start the cleanup session, modify parameters if needed
         */
        RestartCleanupOptions rco = new RestartCleanupOptions();
        rco.setAction(RestartCleanupType.ACTION_JOBRERUN);
        rco.setCleanup(CleanUpOption.MANUAL);
        rco.setUseExpandedJCL(false);
        plan.beginJobRestartCleanup(restartID, rco, null);


        /*
         * Now get datasets lists for the specified restart step
         */
        List datasetList = plan.getJobDataSets(restartID, null);

        /* Here you can modify datasetList if needed*/

        /*
         * Now set the datasets
         */
        plan.setJobDataSets(restartID, datasetList, null);
        /*
         * Now get the JCL
         */
        JobControlLanguage jcl = plan.getJobJCL(restartID, true, null);

        /* Here you can modify jcl if needed*/

        /*
         * Now set the JCL
         */
        plan.setJobJCL(restartID, jcl, true, null);
        /*
         * Execute the step-restart operation
         */
        plan.executeJobRestartCleanup(restartID, "JCL", null, null, null);
        /*
         * commit the step restart phase
         */
        plan.commitJobRestartAndCleanup(JobInPlan.class, restartID, null);

    }
    catch (ConnException e)
    {
        plan.rollbackJobRestartAndCleanup(JobInPlan.class, restartID, null);
    }