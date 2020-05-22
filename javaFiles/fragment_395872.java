public void fillUserList(){    
    List<User> userFriends = ClientController.getInstance().getPrieteniiUserului(user);
    root.removeAllChildren(); //this removes all nodes
    model.reload(); //this notifies the listeners and changes the GUI
    for(int i=0;i<userFriends.size();i++){
        User user = userFriends.get(i);
        model.insertNodeInto(new DefaultMutableTreeNode(user.getNume()), root, i);        
    }
}