ext {
    mysql = ["mysql:mysql-connector-java:${mysql_conn_ver}", 
             "other.package:other-artficact-id:${other.version}"]
}

dependencies{
    compile mysql
    sql mysql
}