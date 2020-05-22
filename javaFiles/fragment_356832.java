public void appendUsersConnectedToChannel(){
    List<String> users = new ArrayList<>();
    for(User i : Main.bot.getUsers(Main.bot.getChannel())){
        users.add(i.getNick());
    }
    for(String i : users){
        append(i + "\n");
    }
}