val target = items.find{ item => 
  if (/* some cond */) { 
    /*other cond*/
  }
  else false
}
target.map(_.myMethod123()).getOrElse(super.myMethod(str1))