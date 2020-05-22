IGraphServiceClient graphClient = GraphServiceClient.
                                  builder().
                                  authenticationProvider(authenticator).
                                  logger(new Slf4jGraphLogger(logger)).
                                  buildClient();

ListItem fileMetadata = 
           graphClient.
           drives(driveId).
           items(item.id).
           listItem().
           buildRequest().get();