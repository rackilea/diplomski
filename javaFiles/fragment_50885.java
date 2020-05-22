private void getAdminToken(RoutingContext ctx, RedisFleetStorage storage, HttpClient httpClient) {

    getVmsAdminToken(fleetId, user, vehicle, httpClient, replyVms -> {
                                            if (replyVms.succeeded()) {
                                               // do you thing
                                            }
                                        });
}