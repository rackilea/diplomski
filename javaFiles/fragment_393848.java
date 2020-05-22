SELECT client.id, client.name ...
FROM (
    SELECT * FROM clients
    ORDER BY name ASC
    LIMIT 10 OFFSET 0
) AS client
LEFT JOIN client_account_types AS cat ON client.id = cat.client_id
FULL JOIN account_types AS at ON cat.account_type_id = at.id;