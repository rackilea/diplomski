final ClientRegistrationManager clientRegistrationManager =
    Mockito.spy(new ClientRegistrationManager(crudService, uniqueIdGenerator);
// doReturn is important because the call to contains a call to the mock
// before Mockito has intercepted it. In your case, this may just create a useless
// real MemberQueries, but in other cases it can throw an exception.
Mockito.doReturn(memberQueries).when(clientRegistrationManager).getMemberQueries();