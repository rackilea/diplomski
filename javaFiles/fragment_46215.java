outer:
do {
    flag=0;
    do {
        ...
        if ((line = br.readLine()) == null) {
            flag = 0;
            break outer;
        }
    } while ((line.trim().startsWith("}")) || flag==0);
    Collections.copy(tag_backup,tag_tester);
}while ((line = br.readLine()) != null || flag==0);