List<UserLog> batchSelect(@Param("userList")List<String> userList, @Param("mailId")Long mallId);

<select id="batchSelect" resultMap="ResultMap">
    select id, user_id, mall_id, log, log_type
    from user_log
    where user_id in (
    <foreach collection="userList" index="index" item="item" separator=",">
      #{item,jdbcType=VARCHAR}
    </foreach>
    ) and mall_id = #{mailId}
  </select>