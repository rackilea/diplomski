Criteria criteria = getCurrentSessionFactory().createCriteria(Utente.class);
crit.createAlias("autenticazione", "autenticazione");
criteria.add(
             Restrictions.eq("autenticazione.username",            
             utenteForSearch.getAutenticazione().getUsername())
             );