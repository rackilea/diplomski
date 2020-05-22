@RequestMapping(value="/{id}",method = RequestMethod.PUT)
@ResponseStatus(HttpStatus.OK)
@ResponseBody
public void updateUser(@PathVariable int id, @RequestBody User temp){
    Set<User> set1= obj2.getUsers();
    for(User a:set1)
    {
        if(id==a.getId())
        {
            set1.remove(a);
            a.setId(temp.getId());
            a.setName(temp.getName());
            set1.add(a);
        }
    }
    Userlist obj3=new Userlist(set1);
    obj2=obj3;
}