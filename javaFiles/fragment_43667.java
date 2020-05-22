public class RoomDetailDto {

String ID;

@NotEmpty
String cd;

@NotEmpty
String name;

String dscp;

// I change below line
RoomCategoryEntity roomCategoryEntity;