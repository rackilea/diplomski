<select id="getFooForUniqueIds" parameterType="java.util.Set" resultMap="foo">
SELECT f.*
  FROM foo f
 WHERE f.id IN <foreach collection="set" item="item" separator="," close=")" open="(">
        #{item}
       </foreach>
</select>