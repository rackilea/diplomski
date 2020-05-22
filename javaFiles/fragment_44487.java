//Do this BEFORE getTransaction/persist/commit
//Set names are just a example, change it to your class setters
u.setUsr(usr);
u.setPwd(pwd);

//Now you can persist or merge it, as i said in the first example
em.getTransaction().begin();
(...)