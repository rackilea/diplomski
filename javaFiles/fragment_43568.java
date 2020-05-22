@ModelAttribute("entity")
public MyEntity getEntity(@RequestParam(required=false) Integer id)
{ 
    if (id == null)
    {
        return myEntityManager.createEntity(entityClass);
    }
    else
    {
        return myEntityManager.find(entityClass, id);
    }
}