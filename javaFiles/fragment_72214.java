/**e1 become persisted after save()**/
 session.save(e1);

/**e1.empName is updated to new value in the DB , but as the direct DML
 will not affect in-memory state , e1.empName in the java side 
 still keeps the old value***/
 session.createQuery("update Employee set empName = \'Jack_new\' where id=1").executeUpdate();

/** As you only set `e1.empName` to its original value , the values of `e1` do 
not have any changes. Thus , during the flushing (which occurs at the moment 
before `commit()`) , hibernate will consider  that `e1` is not dirty  and 
hence no update SQL will be generated and issued to update e1 . 
***/
e1.setEmpName(e1.getEmpName());