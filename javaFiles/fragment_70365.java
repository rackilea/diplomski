<update id="deleteAssociatedEntityForParentEntity" parameterType="com.model.DataParameters">
    update dataTable set deleted = #{deleted}, syncTS = #{syncTS} where
    data_id in
    <foreach item="id" index="index" collection="dataIds"
        open="(" separator="," close=")">
        #{id}
    </foreach>
    and aData_type = #{dataType};

</update>