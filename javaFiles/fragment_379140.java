public interface ClassADAO { 

  @Select("SELECT id, name, description FROM TableA WHERE id = #{id}") 
  @Results({@Result(property = "id", column = "id"), 
            @Result(property = "list", javaType = List.class, column = "id",
              many = @Many(select = "ClassBDao.getClassBForClassA"))}) 
  ClassA getClassAById(@Param("id") long id);

}