private boolean containsOnlyNull(List<Type list) {
   //boolean allNull = true;
    for (Object o : subList) {
        if (o != null)
          //allNull = false;
            return false;
        }
    }
  //return allNull;
    return true;
}