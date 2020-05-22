Query query = new Query();
Criteria criteria = new Criteria();
List<Criteria> orCriterias = new ArrayList<>();
if( dto.getId() != null) {    
  orCriterias.add(Criteria.where("id").is(Integer.parseInt(dto.getId())));
}
... so on for other fields
criteria.orOperator(orCriterias.toArray(new Criteria[orCriterias.size()]));
query.addCriteria(criteria);
List<StudentDTO> recordsList = mongoTemplate.find(query, StudentDTO.class, "student_collection");