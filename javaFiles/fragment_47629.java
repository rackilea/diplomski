EntityManager em = ...;
QProject p = QProject.project;
QFullTimeEmployee e = QFullTimeEmployee.fullTimeEmployee;
List<FullTimeEmployee> emps = new JPAQuery<>(em)
    .select(p)
    .distinct()
    .from(p)
    .innerJoin(p.employees, e._super)
    .where(e.annualSalary.gt(100000))
    .fetch();