<if test="taskowners != null and taskowners.empty == false">

    AND (o.primary_taskowner_id IN
    <foreach item="taskowner" collection="taskowners" open="(" separator="," close=")">
        #{taskowner.id}
    </foreach>

    OR o.secondary_taskowner_id IN
    <foreach item="taskowner" collection="taskowners" open="(" separator="," close=")">
        #{taskowner.id}
    </foreach>)
</if>