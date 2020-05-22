Transaction tx= ses.beginTransaction();
out.println("execution...");    

Query q= ses.createQuery("insert into Student(id,age) select ns.id,ns.age 
                             from NewStudent ns where ns.id=109");

int res= q.executeUpdate();
tx.commit(); // Add this line.