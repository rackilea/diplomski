public interface EventMapper {

    @Select("SELECT * FROM event WHERE date BETWEEN #{from} AND #{to}")
    @Results({
            @Result(property = "id", column = "id"),
            @Result(property = "message", column = "message_id",
                    javaType = Message.class,
                    one = @One(select = "com.company.app.mappers.MessageMapper.getMessage"))
    })
    List<Event> selectInInterval(@Param("from") Date from, @Param("to") Date to);
}