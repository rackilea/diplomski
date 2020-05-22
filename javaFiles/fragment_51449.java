String [] codeTypes = new String[3];
 codeTyes[0]="d";
 codeTypes[1]="p";
 codetypes[2]="c";
 /* note the above would normally be passed into the method containing the code below */
 Criteria criteria = session.createCriteria(AugmentToken.class);
    session.beginTransaction();
 Disjunction disjunction = Restrictions.disjunction();
 for (int x = 0; x < codeTypes.length; x++ ) {
  disjucntion.add(Restrictions.eq("codeType",codeTypes[x]);
 }
 criteria.add(disjunction);