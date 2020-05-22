Query query = getSession().createQuery(
        " from Action a " +
        " join a.actionProperties actProp                      " +
        "   where( (index(actProp) = :key                      " +
        "           and :value in elements(a.actionProperties))" +
        "       or (index(actProp) = :key2                     " +
        "           and :value in elements(a.actionProperties)) )"
        );