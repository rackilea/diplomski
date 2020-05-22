@JsonCreator
CityJSON(
    @JsonProperty("currentCityList") String[] ccl,
    @JsonProperty("brokenCity") String bc,
    @JsonProperty("cityCosts")String[][] cc
){
    currentCityList = ccl;
    brokenCity = bc;
    cityCosts = cc;
}