public String selectField(int... fields) {
    StringBuilder strb = new StringBuilder("Employee{");
    if (fields.length == 0) {
        strb.append("No fields selected ");
    } else {
        for (int i = 0; i < fields.length; i++) {
            switch(fields[i]) {
                case 0: strb.append("eid=" + id + ","); break;
                case 1: strb.append("firstName=" + firstName + ","); break;
                //... and so on
                default: strb.append("-->Field " + fields[i] + " doesn't exist<--");  
            }
        }
    }
    strb.replace(strb.length() - 1, strb.length(), "}");
    return strb.toString();
}