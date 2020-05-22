@ComponentScan(basePackageClasses =
        {
                SampleClass2.class,
        },
        useDefaultFilters = false,
        includeFilters = {@ComponentScan.Filter(
                        type = FilterType.ASSIGNABLE_TYPE,
                        value = {
                                SampleClass2.class,
                        })
})