<select id="getNo" resultType="String" parameterType="map" statementType="CALLABLE">
     #{retval, mode=OUT, jdbcType=VARCHAR}  = CALL pc_sys.f_get_no
     (
      #{notyp, mode=IN, jdbcType=VARCHAR},
     #{ymdDate, mode=IN, jdbcType=DATE}
     );
end;
 </select>