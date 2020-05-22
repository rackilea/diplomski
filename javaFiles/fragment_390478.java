BaseAction baseAction ; // super class
String actionType = rs.getString("action_type"); 
if (actionType.equals("block-break") || actionType.equals("block-place")) {
   BlockAction blockAction = new BlockAction(); // create instance for sub class
   blockAction.set() // set sub class attributes here
   baseAction = blockAction ;

} else if (actionType.equals("entity-kill")) {
   EntityKillAction entityKillAction =new EntityKillAction(); //another subClass
   entityKillAction.set() 
   baseAction = entityKillAction;
}
//set all super class atributes for all
baseAction.setActionTime(rs.getString("action_time"));
baseAction.setActionType(rs.getString("action_type")) ;
// similarly set for all attributes  
actions.add(baseAction);