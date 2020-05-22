package com.stackoverflow.struts2.quartz;

import java.util.HashMap;
import java.util.Map;

import org.apache.struts2.impl.StrutsActionProxyFactory;
import org.quartz.JobExecutionContext;
import org.quartz.JobExecutionException;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionProxy;
import com.opensymphony.xwork2.ActionProxyFactory;

public class QuartzActionProxyFactory extends StrutsActionProxyFactory {

    private static ActionProxyFactory actionProxyFactory;

    public QuartzActionProxyFactory() {
        actionProxyFactory = this;
    }

    public static ActionProxy getActionProxy(JobExecutionContext context) throws JobExecutionException {

        ActionProxy actionProxy = null;

        try {
            @SuppressWarnings("unchecked")
            Map<String, Object> actionParams = context.getJobDetail().getJobDataMap();
            Map<String, Object> actionContext = new HashMap<String, Object>();
            actionContext.put(ActionContext.PARAMETERS, actionParams);

            actionProxy = actionProxyFactory.createActionProxy(
                    (String) actionParams.get(QuartzActionConstants.NAMESPACE),
                    (String) actionParams.get(QuartzActionConstants.NAME), 
                    (String) actionParams.get(QuartzActionConstants.METHOD), 
                    actionContext, 
                    false, //set to false to prevent execution of result, set to true if this is desired 
                    false);

        } catch (Exception e) {
            throw new JobExecutionException(e);
        }

        return actionProxy;
    }

}