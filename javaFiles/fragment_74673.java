<insert id="insertMyObj" parameterType="MyObj">
  INSERT INTO MY_TABLE    (   FIELD_1,
                              FIELD_2,
                              FIELD_3,
                              FIELD_4)
  values  (   #{myField_1},
              #{myField_2},
              #{myChildObject.myField_3},
              #{myChildObject.myField_4},
  )
</insert>