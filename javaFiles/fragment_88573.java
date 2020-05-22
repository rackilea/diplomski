public DataStream<String> getStreamKeyCount(DataStream<Token> stream, 
                                            KeySelector<Token, String> keyExtractor,
                                            Time time, 
                                            Integer maxPetitions, 
                                            String ruleType){

    return stream
         .map(token -> new Tuple3<>(keyExtractor.getKey(token), 1, token.get_tokenId()))
            .keyBy(0)
            .timeWindow(time)
            .process(new MyProcessWindowFunction(maxPetitions, ruleType));
}