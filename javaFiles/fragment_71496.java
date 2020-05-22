@Select("SELECT A.PERSON_ID,A.PERSON_ADDRESS, C.CUSTOMER_NAME," + 
    "       B.CUSTOMER_DOB," + 
    "   FROM PERSON A, CUSTOMER B, CUSTOMER_DETAILS C" + 
    "  WHERE A.CUSTOMER_ID=C.CUSTOMER_ID" + 
    "  AND A.CUSTOMER_ID=B.CUSTOMER_ID (+)" + 
    "  AND C.PERSON_NAME=#{personName, jdbcType=VARCHAR, mode=IN, javaType=String}" + 
    "  AND C.CUSTOMER_ID=#{customerID, jdbcType=VARCHAR, mode=IN, javaType=String}")