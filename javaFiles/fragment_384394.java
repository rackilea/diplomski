public List<HighWay> handleHighways(HighWayRepository repository, Function<HighWayRepository, List<HighWay>> function){
  List<HighWay> highWays = new ArrayList<HighWay>();
        for (RoadCode code : RoadCode.values()) {
            try {

                pageParam.setRoadName(code);
                //call our method 
                highWays.addAll(function.apply(repository));
            } catch (IOException e) {
                IOException exception = dealException(e, code);
                throw exception;
            }
        }
        return highWays;
}