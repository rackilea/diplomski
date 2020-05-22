public String SerializeCommand(ICommand command){

    StringBuilder command_text = new StringBuilder();
    Field [] f = command.getClass().getDeclaredFields();
    try{
    for(Field field : f){
        field.setAccessible(true);
        command_text.append(field.getName() + ",");
        System.out.println("Value :: " + field.get(command));
    }
    }catch(IllegalArgumentException e){
        e.printStackTrace();
    } catch (IllegalAccessException e) {
        e.printStackTrace();
    }
    return command_text.toString();
}