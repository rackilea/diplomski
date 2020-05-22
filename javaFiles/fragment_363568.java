public MalleableObject(ObjectB obj){
    doIBelongToA = false; // if you are directly setting the value without 
    //using obj b then use default constructor.
 }

public MalleableObject(ObjectA obj){
    doIBelongToA = true;
}

/*If you are interested in setting the value based on the reference only there 
  is no problem with your approach as well, One alternative you can take to 
  combine both of them in single constructor and check the reference and set 
  the value accordingly*/