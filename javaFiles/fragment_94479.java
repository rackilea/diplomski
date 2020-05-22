public class ParentController{

    @Autowired
    Validator validator;
    ...

    @RequestMapping(value = "/test",method = RequestMethod.POST)
    public String doPost(ParentDto parentDto, BindingResult bindingResult){
        if(parentDto.isCreateChild()) {
            ValidationUtils.invokeValidator(validator, parentDto, bindingResult, Creation.class);
        } else {
            ValidationUtils.invokeValidator(validator, parentDto, bindingResult);
        }
        if(bindingResult.hasErrors()){
        ...
        }
    }
 }