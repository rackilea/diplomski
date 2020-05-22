String status;
try {
    GeocodingResult[] results =  GeocodingApi.geocode(context,
            address).await();
    status = "OK";
} catch(InvalidRequestException e) {
    status = "INVALID_REQUEST";
} catch(NotFoundException e) {
    status = "NOT_FOUND";
} catch(OverDailyLimitException e) {
    status = "OVER_DAILY_LIMIT";
} catch(OverQueryLimitException e) {
    status = "OVER_QUERY_LIMIT";
} catch(RequestDeniedException | AccessNotConfiguredException e) {
    status = "REQUEST_DENIED";
} catch(ZeroResultsException e) {
    status = "ZERO_RESULTS";
} catch(UnknownErrorException e) {
    status = "UNKNOWN_ERROR";
}