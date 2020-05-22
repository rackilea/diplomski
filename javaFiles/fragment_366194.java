@RequestMapping(value = {"register"}, method = RequestMethod.POST, produces = "application/hal+json")
public Resource<User> registerClient(@RequestBody(required = false) User user, HttpServletRequest request){
    logger.debug("addClient() requested from {}; registration of user ({})", getClientIp(request), user);
    if(user == null){
        throw new BadRequestException()
                .setErrorCode(ErrorCode.USER_IS_NULL.toString())
                .setErrorMessage("Wrong body or no body in reqest");
    } (...)