Map<Long, DTO> dtosById = new LinkedHashMap<Long, DTO>();
List<Object[]> rows = hibernateTemplate.find("select u.id, r from User u inner join u.roles as r");
for (Object[] row : rows) {
    Long id = (Long) row[0];
    Role role = (Role) row[1];
    DTO dto = dtosById.get(id);
    if (dto == null) {
        dto = new DTO(id);
        dtosById.put(id, dto);
    }
    dto.addRole(role);
}
List<DTO> dtos = new ArrayList<DTO>(dtosById.values());