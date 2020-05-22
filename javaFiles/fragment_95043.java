Path<String> col1Path=root.get("col1");
    Path<String> col2Path=root.get("col2");
    Path<String> col3Path=root.get("col3");

    Predicate p1=criteriaBuilder.or(
          criteriaBuilder.and(criteriaBuilder.equal(col1Path,"col1Val1"),
                              criteriaBuilder.equal(col2Path,"col2Val1"),
                              criteriaBuilder.equal(col3Path,"col3Val1") 
                              ), 
          criteriaBuilder.and(criteriaBuilder.equal(col1Path,"col1Val2"),
                   criteriaBuilder.equal(col2Path,"col2Val2"),
                   criteriaBuilder.equal(col3Path,"col3Val2") 
                   )
           );