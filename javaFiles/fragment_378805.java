public class SomeUseCaseTest {
    @Mock
    MyCoolService service;

    @InjectMocks
    SomeUseCase useCase = new SomeUseCase();

    ....
}