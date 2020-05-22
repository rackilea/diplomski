String submittedName=request.getParameter("name");
user=entityManager.find(user.getClass(),submittedName);
Query myQuery=entityManager.createQuery("SELECT u.password FROM UserData u WHERE u.name=:name");
myQuery.setParameter("name", submittedName);
List results=myQuery.getResultList();
String convertedResults=results.get(0).toString();
out.println(results);