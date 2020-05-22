@Select({"<script>",
         "<if 'userId==null'><bind name='userId' value='1'/></if>",
         "SELECT * FROM table WHERE key_name = #{key} ", 
         "AND COALESCE(user_id, -1) = #{userId}", 
         "</script>"})
SomeClass findByKeyAndUserId(@Param("key") String key, @Param("userId") Long userId);