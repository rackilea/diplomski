SELECT tabledatastoreitem.name, tabledatastoreitem.path
FROM tabledatastoreitem
JOIN store ON store.id=tabledatastoreitem.store_id
JOIN service ON service.id = store.service_store_id
JOIN serviceprovider ON service.serviceprovider_id = serviceprovider.id
WHERE serviceprovider.name = 'SystemIService'
  AND store.createdttm < CONVERT(varchar(100), DATEADD(MI, -7, GETDATE()));