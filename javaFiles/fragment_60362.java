select g.*, a.*
from groups g
    join group_participants gp on gp.group_id_foreign = g._id
    left join activityobject a 
        on g._id = a.target_id and 
           a.target_type = 0 and 
           a._id in (select max(_id) from activityobject group by target_id)  
    left join users u on a.user_id_foreign = u.id
where gp.user_id_foreign = ?
order by a._id;