String DbName;
String DbVersion;
...
map = read(this, DbName, DbVersion);

//The DbName and DbVersion is null or empty?

public HashMap<String, String> read(Context con, String name, String version) {

    ...
    DatabaseMap.put(name, GotDbName);   // If name is null, how to get?
    DatabaseMap.put("name", GotDbName); // Maybe 
    DatabaseMap.put(version, GotDbVersion);
    Log.d("Read File", " Database Name =" + GotDbName
            + "Database Version =" + GotDbVersion);
    return DatabaseMap;
}