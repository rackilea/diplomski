SELECT id, name, email
FROM (SELECT id, first_name AS name, email
      FROM single_general
      WHERE unique_code = 'UD'
      UNION ALL
      SELECT 0, name, email
      FROM school
      WHERE unique_code = 'UD');