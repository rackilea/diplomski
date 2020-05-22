return jooqDSLContext.select()
        .from(CL_LOGIN)
        .join(CL_USERS)
        .on(CL_LOGIN.CL_USER_ID.eq(CL_USERS.CL_USER_ID))
        .where(CL_USERS.EMAIL1.eq(email))
        .fetchOneInto(CL_LOGIN);