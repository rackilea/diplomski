if (getEntityManager().contains(entity)) {
    return entity;
}

entity = getEntityManager().merge(entity);

return entity;