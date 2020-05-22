@SubscribeMapping(TOPIC + "/routes/{route_id}")
public MessageWrapper subscribeToRouteLocation(
        @DestinationVariable(value = "route_id") long route_id) {
    LOG.debug("New user subscribed to location of route %d", route_id);
    return new MessageWrapper(LOCATION_MESSAGE, routeService.getBusForRoute(route_id));
}

@MessageMapping("/routes/{route_id}")
@SendTo(TOPIC + "/routes/{route_id}")
public MessageWrapper updateRouteLocation(
        @DestinationVariable(value = "route_id") long route_id,
        @Payload BusStatusUpdateModel busLocation) {
    if (busLocation.getLat() == 0 && busLocation.getLon() == 0) {
        LOG.debug("Ending route %d", route_id);
        return new MessageWrapper(ROUTE_TERMINATED_MESSAGE, routeService.endBusForRoute(route_id));
    } else {
        LOG.debug("Updating location of route %d", route_id);
        BusStatusUpdateModel statusUpdateModel = routeService.updateBusLocation(busLocation, route_id);
        return new MessageWrapper(LOCATION_MESSAGE, statusUpdateModel);
    }
}