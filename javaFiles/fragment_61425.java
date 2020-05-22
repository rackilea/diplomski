Succed success = new Succed();
failure fail = new failure();

for(User d : userlist){
    if(d.getUserUsername().equals(username) && d.getUserPassword().equals(pass)){
        success.setVisible(true);
        break;
    }
}

if(!success.isVisible()){
    fail.setVisible(true);
}