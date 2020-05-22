@NamedQuery(name = "getAccounts", query = "SELECT a" + accountQuery)
@NamedQuery(name = "getAccounts.count", query = "SELECT COUNT(a)" + accountQuery)
.
static final String accountQuery = " FROM Account";
.
  Query q = em.createNamedQuery("getAccounts");
  List r = q.setFirstResult(s).setMaxResults(m).getResultList();
  int count = ((Long)em.createNamedQuery("getAccounts.count").getSingleResult()).intValue();