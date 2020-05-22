else if(dueDateLHS == null && dueDateRHS!=null){
  if(isAscending) { 
    return -1;
  } else 
    return 1;
  }
} else if (dueDateLHS != null && dueDateRHS==null){
//etc
} else if (dueDateLHS == null && dueDateRHS==null){
  return 0;
}