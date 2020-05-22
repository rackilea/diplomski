Criteria cr = session.createCriteria(Vehicle.class);  // Create the criteria on desired class
cr.createAlis("makeModel", "makeModel")
  .createAlias("makeModel.make", "make")
  .createAlias("makeModel.model", "model");  // Creating aliases makes a join on those tables 
if (makeValue != null){
    cr.add(Restrictions.eq("make.make", makeValue))  // If you have a makeValue passed, filter by it
}
if (makeModel != null){
    cr.add(Restrictions.eq("model.modelName", modelValue));  // If you have a makeModel passed, filter by it
}

return cr.list();    // Return the list