-- Add a new service #400
INSERT INTO so_services ( service_id, id_service_provider, valid_from, valid_to )
VALUES ( 400, 20, DATE '2019-08-29', DATE '9999-12-31' );

-- Terminate service 322
UPDATE so_services 
SET    valid_to = DATE '2019-08-29'
WHERE  service_id = 322
AND    valid_to = DATE '9999-12-31';

-- Update service 336
UPDATE so_services 
SET    valid_to = DATE '2019-08-29'
WHERE  service_id = 336
AND    id_service_provider = 37
AND    valid_to = DATE '9999-12-31';

INSERT INTO so_services ( service_id, id_service_provider, valid_from, valid_to )
VALUES ( 336, 88, DATE '2019-08-29', DATE '9999-12-31' );

exec sync_services;