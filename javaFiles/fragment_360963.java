package com.stackoverflow.struts2.quartz;

import org.quartz.Job;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

public class ActionJob implements Job {

    @Override
    public void execute(JobExecutionContext context) throws JobExecutionException {

        try {
            QuartzActionProxyFactory.getActionProxy(context).execute();
        } catch (Exception e) {
            e.printStackTrace();
            throw new JobExecutionException(e);
        }

    }

}