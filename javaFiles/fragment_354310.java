DBTenant dbTenant = new DBTenant();
        Session sess;
        try {
            sess = dbTenant.getTenantSession();
            Query qry = sess.createSQLQuery("{ call Iturria.dbo.CalculoSemaforo2(?,?) }");
            qry.setString(0, this.codigoarticulo);
            qry.setLong(1, this.fecha);
            sem = (Character) qry.uniqueResult();
        }
        catch(NullPointerException e)
        {
            sem = 'y';
            return sem;
        }