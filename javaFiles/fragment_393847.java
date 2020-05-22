SELECT client.id, client.name ...
FROM clients AS client
LEFT JOIN client_account_types AS cat ON client.id = cat.client_id
FULL JOIN account_types AS at ON cat.account_type_id = at.id
ORDER BY client.name ASC
LIMIT 10 OFFSET 30;