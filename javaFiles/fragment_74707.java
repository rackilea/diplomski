public int addPK(TextField tf, DropDown dd, StringBuilder pk, int val) {
    if (((String) dd.getValue()).equals("PRIMARY KEY")) {
        if (val == 0) {
            pk.append((String) tf.getValue());
            val++;
        } else {
            pk.append(", " + (String) tf.getValue());
        }
    }
    return val;
}


public String createButton1_action() {
    StringBuilder primaryKey = new StringBuilder();
    int pkCheck = 0;

    pkCheck = addPK(column_TF1, pkDropDown1, primaryKey, pkCheck);
    pkCheck = addPK(column_TF2, pkDropDown2, primaryKey, pkCheck);
    pkCheck = addPK(column_TF3, pkDropDown3, primaryKey, pkCheck);
    .
    .
}