@Autowired
private RoomEntityToReservationResponseConverter converter;

...
Page<RoomEntity> roomEntityList = pageableRoomRepository.findAll(pageable);
return roomEntityList.map(converter::convert);