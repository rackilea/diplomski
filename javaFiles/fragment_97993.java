<update id="updateProject" parameterType="map">
    <selectKey keyProperty="project.id" resultType="Long" order="BEFORE">
        select nvl(#{project.id}, project_id_seq.nextval) from dual
    </selectKey>
    ...
</update>