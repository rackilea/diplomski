SELECT class_.class_number_ AS "Contract Number",
       COUNT(student_id_number_) AS "Total visits for this Contract Number",
       SUM({FN TIMESTAMPDIFF(SQL_TSI_MINUTE, clock_in_time_, clock_out_time_)})
           AS "Total time for this Contract Number"
FROM student_  
JOIN class_ ON class_id_ = class_.id_ 
GROUP BY class_.class_number_