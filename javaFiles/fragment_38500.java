Map<String, Employee> entityById = 
oldList.stream().collect(Collectors.toMap(Employee::getId, 
Function.identity())); //changed oldList to Map

  for (Employee entity : newList) //iterate new list to check the old values
  {
     if (entityById.containsKey(entity.getId())) // check for updated record
     {
        printActionRecord(entityById.get(entity.getId()), entity, actionDataList,"UPDATED");
        entityById.remove(entity.getId());
     }
     else // check for newly inserted record
     {
        printActionRecord(entityById.get(entity.getId()), entity, actionDataList,"INSERTED");
     }
  }
  if (!entityById.isEmpty()) // check for deleted record from new list( but existing in oldlist)
  {
     entityById.forEach((key, entity) -> {
        printActionRecord(entityById.get(entity.getId()), entity, actionDataList,"DELETED");
     });
  }