Cursor curs = r.db("mytestdb").
                        table("tennis").get(Constants.WORKING_PROJECT_ID)
                        .filter(row -> row.g("new_val").g("time").ne(row.g("old_val").g("time")))
                        .changes().run(conn);

for (Object doc : curs) {

}