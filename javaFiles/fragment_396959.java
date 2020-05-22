{
   "namespace": "example.avro",
   "type": "record",
   "name": "org.apache.avro.file.Header",
   "fields":
   [
      {"name": "Name", "type": "string"},
      {"name": "Id",  "type": ["int", "null"]},
      {"name": "PhoneNumber", "type": ["string", "null"]},
      {"name": "ZipCode", "type": ["int", "null"]},
      {"name": "isAlive", "type": "boolean"}
   ] 
 }