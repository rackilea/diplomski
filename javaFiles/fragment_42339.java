@Autowired
private TimeAspect timeAspect;
@Rule
public MockitoRule mockitoRule = MockitoJUnit.rule();
@Mock
private ProceedingJoinPoint proceedingJoinPoint;

@Test
public void when_create_success() throws JSONException {


    final var vo = prepareVO; 

    RestAssured.given()
        .body(vo)
        //Act
        .contentType(ContentType.JSON)
        .post("/doSomething")
        .then()
        //Assert
        .statusCode(HttpStatus.SC_CREATED)
        .body(not(isEmptyOrNullString()))
        .body(PATH_RESULT, is(SUCESSO.code))
        .body(PATH_DATE_HOUR, not(isEmptyOrNullString()));

    timeAspect.authorizationTime(proceedingJoinPoint, vo);
    verify(proceedingJoinPoint, times(1)).proceed();
}