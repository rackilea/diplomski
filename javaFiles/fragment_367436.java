// Create List<Dummy> as Type
    Generic generic = TypeDescription.Generic.Builder
            .parameterizedType(List.class, Dummy.class).build();

    Class<? extends Example> loaded = new ByteBuddy().subclass(Example.class)
            .defineField("names", generic, Visibility.PRIVATE).make()
            .load(ByteBuddyEnhancer.class.getClassLoader(), ClassLoadingStrategy.Default.INJECTION).getLoaded();