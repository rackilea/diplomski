List<User> usersByMock = new ArrayList<>();
usersByMock.add(...);
usersByMock.add(...);
usersByMock.add(...);
...
when(userRepository.findAll()).thenReturn(usersByMock);