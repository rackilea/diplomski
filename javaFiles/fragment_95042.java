Path<String> col1Path=root.get("col1");
    Path<String> col2Path=root.get("col2");
    Path<String> col3Path=root.get("col3");

    Predicate p0=criteriaBuilder.concat(col1Path,col2Path,col3Path)
         .in("col1Val1"||"col2Val1"||"col3Val1",
              "col1Val2"|| "col2Val2"|| "col3Val2");