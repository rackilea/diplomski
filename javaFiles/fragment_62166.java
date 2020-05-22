public String save(SubDepartment subDepartment){

    String id=subDepartment.getSubDepartmentId();
    subDepartment.setModifiedOn(new Date());
    mongoTemplate.updateFirst(new Query(Criteria.where("_id").is(id)), new Update("modifiedOn"), SubDepartment.class);
    mongoTemplate.save(subDepartment, subDepartmentCollection);

 }