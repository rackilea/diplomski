<select id="getSth" resultClass="Object" parameterClass="Object">
     select * from table
     <isNotEmpty property="startDate" >
         <isNotEmpty property="endDate" >
            where date_start &gt;= #startDate# AND date_end &lt;= #endDate#
         </isNotEmpty>
    </isNotEmpty>
</select>