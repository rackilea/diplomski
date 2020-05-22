public void addPK(TextField tf, DropDown dd, StringBuilder pk) {
    if (((String) dd.getValue()).equals("PRIMARY KEY")) {
        if (pk.length()== 0) {
            pk.append((String) tf.getValue());
        } else {
            pk.append(", ").append((String) tf.getValue());
        }
    }
}