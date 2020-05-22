<where>
    <if test="apiConsumerIdsList != null">
    api_consumer IN <foreach item="item" collection="apiConsumerIdsList" 
            open="(" separator="," close=")">
          #{item}
        </foreach>
    </if>
    <if test="serviceIdsList != null">
        AND service IN <foreach item="item" collection="serviceIdsList" 
                open="(" separator="," close=")">
              #{item}
            </foreach>(#{serviceIdsList,jdbcType=ARRAY})
    </if>
    <if test="status != null">
        AND status IN <foreach item="item" collection="status" 
                open="(" separator="," close=")">
              #{item}
            </foreach>
    </if>
    <if test="dateFrom != null">
        AND date &gt;= #{dateFrom:DATE}
    </if>
    <if test="dateTo != null">
        AND date &lt;= (#{dateTo:DATE})
    </if>
</where>