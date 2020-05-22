@Mapping(target="childs", source="childs") // you can omit @Mappings in java8
    void merge(@MappingTarget Target result, Source request);

    default void merge(@MappingTarget List<ChildTarget> result, List<ChildSource> source ) {
       // write whatever merge functionality you desire and call 'merge' for the ChildTarget / ChildSource here
    }  

    void merge(@MappingTarget ChildTarget result, ChildSource request);
}