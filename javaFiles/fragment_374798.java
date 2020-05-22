@POST
@Path("testRest")
@Consumes({MediaType.APPLICATION_JSON})
@Produces({MediaType.APPLICATION_JSON})
public static NotificationResponse testRest(Notification n) {
    logger.info("yo!");
    return new NotificationResponse(101, "yo");
}