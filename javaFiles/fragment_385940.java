@Transactional
public Person createUpdatePerson(PersonDTO dto) {
   Person entity = dao.find(dto.getId());
   if (entity == null) {
      entity = new Person();
   }

   //merge update
   entity.setName(dto.getName()); 
   entity.setAge(dto.getAge());
   //etc
   return dao.save(entity);
}