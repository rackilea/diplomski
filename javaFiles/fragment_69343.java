public class AssociateJob {


    public int associate() {

        String sql = 
           "UPDATE stuff AS s SET instruction_id = " + 
           "(SELECT i.id FROM instruction AS i WHERE " + 
           "i.name LIKE s.name AND i.form LIKE s.form )" +
           " WHERE instruction_id IS NULL";

        SqlUpdate update = Ebean.createSqlUpdate(sql);

        return update.execute();

    }


}