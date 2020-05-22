// BodyHandler FIRST !!!
_router.route().handler(BodyHandler.create());
// AuthHandler SECOND
_router.route().handler(_basicAuthHandler);
// DO NOT CREATE BodyHandler AFTER AuthHandler
//_router.route().handler(BodyHandler.create());