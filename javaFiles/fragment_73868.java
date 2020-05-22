public <T> T runCommand(MyCommand<T> command){
  if(someCondition){
    //Run it in context or whatever 
    return command.execute();
  } else {
    return command.execute();
  }
}