Thread t=new Thread(){
    public void run(){
        try
        {
            DynamoDBClient dbClient = new DynamoDBClient();

            dbClient.DynamoDB();
            dbClient.createTable();


        } catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}