SELECT class_.class_number_ AS "Contract Number",
       first_name_ || ' ' ||  last_name_ AS "Student Name",
       class_.class_ AS "Class",
       MAX(ALL DATE(clock_in_time_)) AS "Latest Date",
       COUNT(student_.id_) AS "visits",
       SUM({FN TIMESTAMPDIFF(SQL_TSI_MINUTE, clock_in_time_, clock_out_time_)})
         AS "Total Time in Minutes"
FROM student_  
JOIN class_ ON class_id_ = class_.id_ 
GROUP BY class_.id_, class_.class_number_, class_.class_, 
         student_id_number_, first_name_, last_name_