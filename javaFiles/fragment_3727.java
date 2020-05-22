Accessor accessor = mock(Accessor.class);
GroupAccessor groupAccessor = mock(GroupAccessor.class);

Optional<Accessor> optAccessor = Optional.of(accesor)
when(mockRequestContext.getAccessor()).thenReturn(optAccessor)
when(accessor.getGroupAccessor()).thenReturn(groupAccessor);
when(groupAccessor.getGroupId()).thenReturn("s1");