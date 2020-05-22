@Mapping( target = "userNumbers", source = "phoneNumbers" )
Target map( Source source );

@AfterMapping // will be applied in the final part of the previous method
default void map ( Source source, @MappingTarget Target target ) {
 target.getUserNumbers().addAll(source.getFaxNumbers());
}