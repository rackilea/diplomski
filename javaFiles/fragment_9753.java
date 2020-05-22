OneToManyMapping mapping = (OneToManyMapping) descriptor.getMappingForAttributeName( "someRelationship" );
Expression origExp = mapping.buildSelectionCriteria();
ExpressionBuilder expBuilder = origExp.getBuilder();
Expression constantExp = expBuilder.get( "someAttribute" ).in( new String[] { "V", "W", "U" } );
Expression newExp = origExp.and( constantExp );
mapping.setSelectionCriteria( newExp );