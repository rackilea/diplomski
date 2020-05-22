public class StateInfoAggregator implements ArgumentsAggregator {
    @Override
    public StateInfo aggregateArguments(ArgumentsAccessor arguments, ParameterContext context) {
        return new StateInfo(arguments.getString(0),
                             arguments.getInteger(1),
                             arguments.getInteger(1));

    }
}

@ParameterizedTest
@CsvSource({
        "FL, 1, 1",
        "OH, 2, 2",
        "MI, 3, 3"
})
void csvInputTest(@AggregateWith(StateInfoAggregator.class) StateInfo stateInfo) {
    System.out.println(stateInfo.getStateCode() + " - " + stateInfo.getVal1() + " - " + stateInfo.getVal2());
}