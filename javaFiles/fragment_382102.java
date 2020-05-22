function startWorkflow()
{
    var workflowAction = workflow.getDefinitionByName("activiti$test_wf");
    var package= workflow.createPackage();

    var wfparams = new Array();
    wfparams["model_prefix:req_props_name"] = value2;

    wfparams["bpm:assignee"] = people.getPerson("ADMIN");
    workflowAction.startWorkflow(package, wfparams);
    }

}

startWorkflow();