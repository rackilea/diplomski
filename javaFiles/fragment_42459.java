expr = new StringBuilder()
    .append(MYSQLDUMP_CMD).append(' ')
    .append("-u").append(USER_DEFAULT).append(' ')
    .append("-p").append(PW_DEFAULT).append(' ')
    .append(TEST_DB_NAME).append(' ')
    .append(">").append(' ')
    .append(DUMP_LOC)
    .toString();
return new String[] {"/bin/bash", "-c", expr};