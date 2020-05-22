@Inject
@UserMapper
private BoundMapperFacade<UserEntity, UserWeb> userMapper;
...
UserEntity entity = userMapper.mapReverse(userWeb);
mapper.map(entity);