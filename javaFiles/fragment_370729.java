Predicate[] p1 = new Predicate[2];
Predicate[] p2 = new Predicate[2];
Predicate[] p3 = new Predicate[2];
// add your predicates to the arrays.     
Predicate p1all = cb.and(p1);    
Predicate p2all = cb.and(p2);
Predicate p3all = cb.and(p3);
Predicate pFinal = cb.or(cb.and(p1all, p2all), p3all);
criteria.where(pFinal);