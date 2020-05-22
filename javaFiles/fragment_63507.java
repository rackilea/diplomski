Map<String, List<MyDTO>> hitmap = new HashMap<String, List<MyDTO>>();

for (MyDTO dto: dtos){
  String webname = dto.getMyClass().getWebName();
  List<MyDTO> list = hitmap.get(webname);
  if (list==null){
    list = new ArrayList<MyDTO>();
    hitmap.put(webname, list);
  }
  list.add(dto);
}