@NamedQueries({
  @NamedQuery(name="findProfessorsAboveSal",
              query="SELECT e " +
                    "FROM Professor e " +
                    "WHERE e.department = :dept AND " +
                    "      e.salary > :sal AND e.id IN(1000)"),
  @NamedQuery(name="replicateError", query="select e from Professor e where "+
"e.id in(select prj from Project prj where prj.id = ?1)")})