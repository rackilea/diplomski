List queryTerms = null;

 if (tsym) {
     queryTerms = buildTreasuryQueryTerms(event, budgetLevel, null, null);
 } else {
     queryTerms = new ArrayList();
 }