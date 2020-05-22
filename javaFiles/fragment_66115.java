static String p,p1,p2,p3;
    gender(String selfGender){

    if (null != selfGender) 
    switch (selfGender) {
        case "Male":
            p="he";
            p1="his";
            p2="him";
            p3="himself";
            break;
        case "Female":
            p="she";
            p1="her";
            p2="her";
            p3="herself";
            break;
        case "Non Binary":
            p="they";
            p1="them";
            p2="their";
            p3="themself";
            break;
        default:
            break;
    }
}