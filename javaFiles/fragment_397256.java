final LoadingCache<Serializable, Optional<ITemplate>> templatesById = CacheBuilder.newBuilder()
        .maximumSize(MAX_CACHE_SIZE).expireAfterAccess(MAX_CACHE_LIFE_TIME, TimeUnit.MINUTES)
        .build(new CacheLoader<Serializable, Optional<ITemplate>>() {

            @Override
            public Optional<ITemplate> load(final Serializable id) {
                final ITemplate template = readInternal(id);
                final Optional<ITemplate> optional = Optional.ofNullable(template);
                if (template != null) {
                    templatesByKey.put(template.getKey(), optional);
                }
                return optional;
            }
        });

final LoadingCache<String, Optional<ITemplate>> templatesByKey = CacheBuilder.newBuilder()
        .maximumSize(MAX_CACHE_SIZE).expireAfterAccess(MAX_CACHE_LIFE_TIME, TimeUnit.MINUTES)
        .build(new CacheLoader<String, Optional<ITemplate>>() {

            @Override
            public Optional<ITemplate> load(final String key) {
                final ITemplate template = byKeyInternal(key);
                final Optional<ITemplate> optional = Optional.ofNullable(template);
                if (template != null) {
                    templatesById.put(template.getId(), optional);
                }
                return optional;
            }
        });