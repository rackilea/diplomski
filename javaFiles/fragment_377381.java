public class MathOpTest {
  @Mock private Calculator mockCalculator;
  @Mock private Supplier<Double> mockPreviousResultSupplier;
  private MathOp mathOp;

  @Before
  public void createMathOp() {
    MockitoAnnotations.initMocks(this);
    mathOp = new MathOp(
        mockCalculator, mockPreviousResultSupplier);
  }

  ...
}