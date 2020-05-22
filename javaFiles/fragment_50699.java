SELECT s.school_id, u.first_name, u.last_name, u.username, u.email, p.plan_name, s.start_date, s.end_date,
       (SELECT COUNT(*) FROM c_school_user t WHERE t.user_type = 'TA' and t.school_id = s.school_id) as ta_count, 
       (SELECT COUNT(*) FROM c_school_user t WHERE t.user_type = 'PA' and t.school_id = s.school_id) as pa_count, 
       (SELECT COUNT(*) FROM c_school_user t WHERE t.user_type = 'ST' and t.school_id = s.school_id) as st_count
FROM c_school s 
  inner join u_user u on s.user_created = u.user_id 
  inner join c_plan p on s.current_plan = p.plan_Id 
where s.application_id = 1 and s.site_id = 1;