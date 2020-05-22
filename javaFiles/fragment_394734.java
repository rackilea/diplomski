List<Long> photoIds = (List<Long>)
    em.createNativeQuery(
    "select data.p_id
        from 
        (
            SELECT p.id as p_id, row_number() as rw OVER w as rw
            FROM photo p
            INNER JOIN galley g on g.id = p.galery_id
            INNER JOIN user u on u.id = g.user_id
            WINDOW w AS (PARTITION BY u.id ORDER BY p.creation_time DESC)
        ) data 
        where rw <= 3", Long.class)
.getResultList();