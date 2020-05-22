public class Controller implements test {

    public Response execute(test t) throws A {

        TextResponse tr = t.createTextResponse();

        t.setContentType("application/json");

        try {


            String term = t.getParameters().getSingle("test");


            String sqlJson = t.createSQL("Select id AS value, c_first_name + ' ' + c_last_name AS label, c_address_1 AS [desc] from t_ct where c_first_name like '%" + term + "%' order by c_first_name ").fetchJSON();

            t.put("aadata", sqlJson);


        }catch (Exception e ) {

            e.printStackTrace();
        }


        return tr;

    }

}