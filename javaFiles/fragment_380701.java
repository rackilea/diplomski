if (em.contains(e)) {
        em.remove(e);
    } else {
        BaseEntity ee = em.getReference(e.getClass(), e.getId());
        em.remove(ee);
    }