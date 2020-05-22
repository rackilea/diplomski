int recursivefunc(String expression){
    result = 0;
 while (have token){
   if token is add/subtract/divide -{
     result = result + "token operation result"
    }else if token is open bracket{
      find end bracket (not the first if there are more open brackets)
       result = result + recursivefunc(sub-expression)
    }
  }
  return result
}