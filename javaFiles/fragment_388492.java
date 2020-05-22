public String searchStateName(String stateName){
 String result = "No city found.";
      for (SC sc : list )
         if (sc.getStateName().equalsIgnoreCase(stateName)){
          result = sc.getCityName();
          break;
        }
    }
 return result;
}