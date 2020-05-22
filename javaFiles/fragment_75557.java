INSERT INTO pet (pet_id, pet_type, name) 
         VALUES (?, CAST(? AS animal_type), ?);

--or

INSERT INTO pet (pet_id, pet_type, name) 
         VALUES (?, ?::animal_type, ?);