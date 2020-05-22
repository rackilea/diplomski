for (int i = 0; i < columns.length; i++) {
        // replace comma Plus space
        String field = columns[i].replaceAll(", ", "||',ASPACEHERE'||");
        // replace space
        field = field.replaceAll(" ", "||' '|| ");
        field = field.replaceAll("ASPACEHERE"," ");
        fields += ",("+field+") AS '" + columns[i] + "' ";
    }
    String query = "SELECT MemberId"+fields+" FROM tblMember ";