public void executeQuery()
{
    ResultSet rset = stmt.executeQuery("select  DISTINCT  substr(file_type,1,3) from DBM.file_table where process_time= '0015' ");

    while (rset.next())
    {    
        final r = rset.getString(1);
        System.out.println(r);
        Thread th = new Thread ( new Runnable()
        {
            @Override
            public void run()
            {
                method(r);
            }
        });
        th.start();
    }
}
public synchronized void method(String r)
{
    String spCall = "call DBM.SP_MS_" + r + "('0015', NULL, SYSDATE, 'DBM')";

    try {
        dbConnection = getDBConnection();
        stmt1 = dbConnection.createStatement();

        System.out.println(spCall);

        stmt1.executeUpdate(spCall);

        System.out.println("SUCCESS for File_Type " + r );
        System.out.println("-----------------------------");
    } catch (SQLException e) {

        System.out.println(spCall);

        stmt1.executeUpdate(spCall);

        System.out.println("SUCCESS for File_Type " + r );
        System.out.println("-----------------------------");
    } catch (SQLException e) {}
}