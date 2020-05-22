public class TwitterAPI {

    private static String server_name = "localhost:7777";
    private static String twitter_databse = "twitter";
    private static String username = "root";
    private static String password = "password";
    public static String twitter_unique_usernames_file = "twitter_unique_usernames_file.txt";
    public static String language_model_file = "C:\\de\\JARS\\lingpipe-4.0.0\\demos\\models\\langid-leipzig.classifier";
    public static DataSource dataSource = DBUtils.getDataSource(server_name, twitter_databse, username, password);

    public static Connection startDBConnection(String server_name, String database, String username, String password) {
        //Set DB parameters
        //DBUtils mysql_obj = setDBParams(server_name, database, username, password);               

        Connection connection = null;
        //connection = mysql_obj.createConnection();
        try {
            connection = dataSource.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    public static DBUtils setDBParams(String server_name, String database, String username, String password){

        DBUtils mysql_obj = new DBUtils();
        mysql_obj.setServer_name(server_name);
        mysql_obj.setDatabase(database);
        mysql_obj.setUsername(username);
        mysql_obj.setPassword(password);
        return mysql_obj;
    }

    public static String getTweets(BigInteger id){

        Connection connection = startDBConnection(server_name,twitter_databse,username,password);       
        ResultSet resultSet = null;     
        String tweet = new String();
        try {           
            Statement statement = connection.createStatement();
            String query = SQL_queries.get_tweets_on_id  + id.toString();

            //Execute the query
            resultSet = statement.executeQuery(query);          

            while(resultSet.next()){
                tweet = resultSet.getString("content");
            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        finally{
            try {
                connection.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return tweet;
    }