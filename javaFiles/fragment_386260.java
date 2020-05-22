void removeHierarchy( List<Employee> managers )
  {
    List<Employee> toBeRemoved = new ArrayList<>();
    for ( Employee manager : managers )
    {
      removeHierarchy( manager.getEmployees() );
      if (0 == manager.getSalary() && manager.getEmployees().isEmpty()) {
        toBeRemoved.add( manager );
      }
    }
    managers.removeAll( toBeRemoved );
  }