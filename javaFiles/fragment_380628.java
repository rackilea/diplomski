@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.PARAMETER)
@AggregateWith(StateInfoAggregator.class)
public @interface CsvToStateInfo {
}

@ParameterizedTest
@CsvSource({
        "FL, 1, 1",
        "OH, 2, 2",
        "MI, 3, 3"
})
void csvInputTest(@CsvToStateInfo  StateInfo stateInfo) {
    System.out.println(stateInfo.getStateCode() + " - " + stateInfo.getVal1() + " - " + stateInfo.getVal2());
}