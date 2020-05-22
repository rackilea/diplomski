public List<Listener> findAll(long timestamp, long now, Pageable pageable) {
return super.find(currentSession()
                .createCriteria(Listener.class, "listener")
                .createAlias("listener.paths", "path")
                .createAlias("listener.tlsDescriptor", "tls", JoinType.LEFT_OUTER_JOIN)
                .add(Restrictions.or(
                        Restrictions.between("audit.modifyTimestamp", new Date(timestamp), new Date(now)),
                        Restrictions.between("path.audit.modifyTimestamp", new Date(timestamp), new Date(now)),
                        Restrictions.between("tls.audit.modifyTimestamp", new Date(timestamp), new Date(now)))),
        pageable);