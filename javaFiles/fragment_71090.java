List resultWithAliasedBean = s.createCriteria(Enrolment.class)
  .createAlias("student", "st").createAlias("course", "co")
  .setProjection( Projections.projectionList()
                   .add( Projections.property("st.name"), "studentName" )
                   .add( Projections.property("co.description"), "courseDescription" )
          )
          .setResultTransformer( Transformers.aliasToBean(StudentDTO.class) )
          .list();

 StudentDTO dto = (StudentDTO)resultWithAliasedBean.get(0);