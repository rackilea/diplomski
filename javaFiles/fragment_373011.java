<select id="selectPostIn" resultType="domain.blog.Post">
  SELECT *
   FROM POST P
   WHERE ID in
   <foreach item="item" index="index" collection="list" open="(" separator="," close=")">
    #{item}
   </foreach>
</select>