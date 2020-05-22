List <Object[]> results = sessionFactory.getCurrentSession().createQuery("select i.F_NO, i.LAST_NAME, i.FIRST_NAME, i.HOME_PHONE, i.SEX_NO from Data i where f_no = :f_no")
                .setParameter("_no",  no).list();
JSONObject jObject = new JSONObject();
try
{
    JSONArray jArray = new JSONArray();
    for (NewPojo obj: results)
    {
         JSONObject studentJSON = new JSONObject();
         studentJSON.put("objfname", obj.getFName());
         studentJSON.put("objlname ", obj.getLName());
         jArray.put(studentJSON);
    }
    jObject.put("NewList", jArray);
} catch (JSONException jse) {
    jse.printStacktrace();
}