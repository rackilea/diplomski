public static final int DEFAULT_VALUE_WHEN_GET_LAST_ITEM_FAILED = 1;
...
@Transactional(rollbackFor = ExpectedException.class)
public int getSomeValue(){

    try {
      MyObj obj = repo.getLastItem(); // this failed because not items in table, so I need here null   
      if (obj != null) {          
          return calculatedValue();
        }                     
    }
    catch(ExpectedException e){  
       //TODO exception logging
    }

    return DEFAULT_VALUE_WHEN_LAST_ITEM_FAILED;

}