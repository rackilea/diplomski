Table<Record4<String, String, Integer, Timestamp>> insertValues = values(
    row(
        cast(null, COMPANY.COMPANY_NAME),
        cast(null, PERSON.PERSON_NAME),
        cast(null, EMPLOYMENT_CONTRACT.SALARY),
        cast(null, EMPLOYMENT_CONTRACT.CREATION_DATE_TIME)
    )
).as("insert_values", "company_name", "person_name", "salary", "creation_time");
Field<String> ivCompanyNmae = field("insert_values.company_name". Stirng.class);
Field<Integer> ivSalary = field("insert_values.salary", Integer.class);
...

Insert<AffectedSubscriberRecord> insert = insertInto(EMPLOYMENT_CONTRACT)
    .columns(EMPLOYMENT_CONTRACT.COMPANY_ID,
        EMPLOYMENT_CONTRACT.PERSON_ID,
        EMPLOYMENT_CONTRACT.SALARY,
        EMPLOYMENT_CONTRACT.CREATION_DATE_TIME
    )
    .select(
        select(
            COMPANY.COMPANY_ID,
            PERSON.PERSON_ID,
            ivSalary,
            ivCreatedTime
        )
        .from(insertValues)
            .join(COMPANY).using(COMPANY.COMPANY_NAME)
            .join(PERSON).using(PERSON.PERSON_NAME)
     );