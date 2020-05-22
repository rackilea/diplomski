public class Test {

private static final String FILENAME = "D:/Idfile.txt"; // Your Id file

private SessionFactory sessionFactory;

public static void main(String[] args) {

    ApplicationContext context = new    ClassPathXmlApplicationContext("resource/spring/applicationContext.xml");

    Test test = new Test();
    test.readFile();

}

private void readFile() {

    BufferedReader br = null;
    FileReader fr = null;

    try {

        fr = new FileReader(FILENAME); // You read the file here
        br = new BufferedReader(fr);

        String sCurrentLine;

        br = new BufferedReader(new FileReader(FILENAME));

        while ((sCurrentLine = br.readLine()) != null) {
            if (!checkIfIdExists(sCurrentLine)) {
                System.out.println("Some problem"); // Handle the exception
                                                    // scenario here.
            }
        }

    } catch (IOException e) {

        e.printStackTrace();

    } finally {

        try {

            if (br != null)
                br.close();

            if (fr != null)
                fr.close();

        } catch (IOException ex) {

            ex.printStackTrace();

        }

    }

}



private boolean checkIfIdExists(String sCurrentLine) {
    Session session = null;
    Transaction tx = null;
    try {
        session = sessionFactory.openSession();
        session.setFlushMode(FlushMode.AUTO);
        tx = session.beginTransaction();

        String sql = "SELECT text_file_id, primary_key from demo_table where text_file_id = :text_file_id "; // Check if the ID is present
        SQLQuery query = session.createSQLQuery(sql);
        query.addEntity(LookUpDemoTable.class);
        query.setParameter("text_file_id", sCurrentLine);
        List results = query.list();
        if (results.size() != 0) {


            for (Iterator<LookUpDemoTable> it = results.iterator(); it.hasNext();) {

                LookUpDemoTable lookUpDemoTableToUpdate = new LookUpDemoTable();
                LookUpDemoTable lookUpDemoTable = it.next();
                lookUpDemoTableToUpdate.setPrimaryKey(lookUpDemoTable.getPrimaryKey());
                session.saveOrUpdate(lookUpDemoTableToUpdate); // Incase the ID is present
                tx.commit();
            }

        } else {
            LookUpDemoTable lookUpDemoTableToInsert = new LookUpDemoTable();
            lookUpDemoTableToInsert.setPrimaryKey(new Long(System.currentTimeMillis()).toString());
            lookUpDemoTableToInsert.setTextFileId(sCurrentLine);
            session.save(lookUpDemoTableToInsert); // Incase the ID is not present
            tx.commit();
        }
        return true;

    } catch (Exception e) {
        tx.rollback();
    } finally {
        if (null != session) {
            session.close();
        }
    }

    return false;

  }
}