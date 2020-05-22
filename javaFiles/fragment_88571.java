((JpaEntityManager) entityManager.getDelegate())
            .getActiveSession()
            .getIdentityMapAccessor()
            .printIdentityMaps();
((JpaEntityManager) entityManager.getDelegate())
            .getActiveSession()
            .getIdentityMapAccessor()
            .printIdentityMap(MyClass.class);