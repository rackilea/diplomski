private String roleName;

 @UniqueValue(query = AppConstants.UNIQUE_VALIDATION_DB_QUERY)
 public Map<String,String> getUniqueValidator(){
   Map<String,String> validatorMap=new HashMap<String,String>();

   validatorMap.put("ACTION",type of action(update/new)):
   validatorMap.put("VALUE",this.roleName):
   return validatorMap;
 }

 public String getRoleName() {
        return roleName;
 }

 public void setRoleName(String roleName) {
        this.roleName = roleName;
 }