@RequestMapping(value="/batch",method=RequestMethod.GET)
@ResponseStatus(value=HttpStatus.OK)
public @ResponseBody String getMore(@RequestParam(value="splitCondition",required=false,defaultValue="")String userids) {
    String result="";
    String[] ids=userids.split(" ");
    for (String id : ids) {
    Users users =   usersService.findById(Integer.parseInt(id));
    if(users!=null) {
        result= (result+" " + users.getRealname()).trim();
    }
    }
    return result;
}