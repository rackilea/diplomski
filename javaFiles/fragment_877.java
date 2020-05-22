List<MyDomainClass> results = (List<MyDomainClass>) getSession()     
.createCriteria(MyDomainClass.class)
.setFirstResult(5)
.setMaxResults(5)
.addOrder(Order.asc("date"))
.list();