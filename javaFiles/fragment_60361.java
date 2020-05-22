select g.*, a.time, a.type, u.user_name, u.user_image                             
from groups g
    join group_participants gp on gp.group_id_foreign = g._id
    left join activityobject a on g._id = a.target_id and a.target_type = 0
    left join user u on a.user_id_foreign = u.id
where gp.user_id_foreign = ?
order by a._id;