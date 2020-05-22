private final static String STORED_PROCEDURE = "public.someFunction";

    StoredProcedureQuery query = em.createStoredProcedureQuery(STORED_PROCEDURE);
    query.
            registerStoredProcedureParameter(1, String.class, ParameterMode.IN).setParameter(1, type_proc).
            registerStoredProcedureParameter(2, String.class, ParameterMode.IN).setParameter(2, node).
            registerStoredProcedureParameter(3, String.class, ParameterMode.IN).setParameter(3, fullcode).
            registerStoredProcedureParameter(4, Date.class, ParameterMode.IN).setParameter(4, bdate).
            registerStoredProcedureParameter(5, LongType.INSTANCE, ParameterMode.IN).setParameter(5, null).
            execute();