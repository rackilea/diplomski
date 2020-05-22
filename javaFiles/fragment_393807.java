Criteria mastersCriteria = getSession().createCriteria(Student.class, "student");
    mastersCriteria.setResultTransformer(Criteria.DISTINCT_ROOT_ENTITY);    
    mastersCriteria.createAlias("student.resume", "resume"); 
    mastersCriteria.createAlias("resume.masters","masters");

    if (degreeslist.size() == 1) {
          mastersCriteria.add(Restrictions.eq("masters.degreeName", degreeslist.get(0)));  
    } else {
          mastersCriteria.add(Restrictions.in("masters.degreeName", degreeslist));
    }


    List<Student> students = mastersCriteria.list();