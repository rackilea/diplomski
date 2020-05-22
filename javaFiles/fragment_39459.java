@RestController
public class TestEndpoint{
    @Autowired
    ProcessEngine processEngine;

    @GetMapping(path = "x")
    public String test(){
        ProcessInstance processInstance = processEngine.getRuntimeService().startProcessInstanceByKey("account_close_flow");
        HistoricVariableInstanceEntity variable = (HistoricVariableInstanceEntity) processEngine.getHistoryService()
                .createHistoricVariableInstanceQuery()
                .processInstanceId(processInstance.getId())
                .variableName("globalError").singleResult();
        if(variable != null)
           throw new ResponseStatusException(HttpStatus.BAD_REQUEST, processInstance.getId() +" "+variable.getTextValue());

        return "hi";
    }
}