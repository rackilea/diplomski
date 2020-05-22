@Profile("prd")
public class PersonManagerServiceImpl implements PersonManagerService

//...

@Profile("test")
public class PersonManagerServiceMock implements PersonManagerService

//...

@ContextConfiguration
@ActiveProfiles(value = "test")
public class Test {