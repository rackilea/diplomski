Disjunction disjunction =Restrictions.disjunction();
 Conjunction conjunction =Restrictions.conjunction(); 
 for (int i=0; i<andOrButtonFilter.length; i++)
    {
        if("and".equals(andOrButtonFilter[i]))
        {         
            if ((column.get(i) != null) && (value.get(i)!=null))
            {
                conjunction.add(Restrictions.eq(column.get(i), value.get(i)));             
            }
        }
        else if("or".equals(andOrButtonFilter[i]))
        {           
            if ((column.get(i) != null) && (value.get(i)!=null))
            {
                disjunction.add(Restrictions.eq(column.get(i), value.get(i)));              
            }
        }
        else 
        {
            criteriaQuery.add(Restrictions.eq(column.get(i), value.get(i)));
        }
    }
    criteriaQuery.add(conjunction);
    criteriaQuery.add(disjunction);