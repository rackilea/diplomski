CREATE TYPE EMP_REC AS OBJECT
(
 id employees.employee_id%type,
 name employees.last_name%type,
 dept_name departments.department_name%type,
 job_title jobs.job_title%type,
 salary employees.salary%type,
 manager_id employees.employee_id%type,
 city locations.city%type,
 phone employees.phone_number%type
);