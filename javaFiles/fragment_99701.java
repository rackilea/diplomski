HibernateLoopDataSource(Session hibernate, 
                        Class<?> typeOfClass, 
                        AppliedCriteria appliedCriteria){
    this.hibernate = hibernate;
    this.typeOfClass = typeOfClass;
    // you should have this.appliedCriteria = appliedCriteria here
}