SELECT 
    area_time.Area,
    ourcases.Fatal,
    person.Sex
FROM
    area_time,
    ourcases,
    person
WHERE
    area_time.Case_Number = ourcases.Case_Number
        AND area_time.Case_Number = person.Case_Number
        AND person.Case_Number = ourcases.Case_Number
        AND ourYear = 2016
        AND ourTime = 'Afternoon'
        AND Area = 'Florida';