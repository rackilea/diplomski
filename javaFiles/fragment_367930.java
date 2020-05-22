@ComponentScan(
    excludeFilters = {
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = OAuthCacheServiceImpl.class),
        @ComponentScan.Filter(type = FilterType.ASSIGNABLE_TYPE, value = Application.class)
    },
    basePackages = {
        "common", "adapter", "admin"
    }
)