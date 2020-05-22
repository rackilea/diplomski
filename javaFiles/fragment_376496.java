String _id = "";
String _nom = "";
String _prenom = "";

while (data.moveToNext()) {
    _id = data.getString(1);
    _nom = data.getString(2);
    _prenom = data.getString(3);

    if(_id == null || _nom == null || _prenom == null) {
        System.out.println("Database field is null!");
    }
    else {
        userList.add( new User( _id, _nom, _prenom));
        System.out.println(_id  + " " + _nom  + " " + _prenom);
    }
}