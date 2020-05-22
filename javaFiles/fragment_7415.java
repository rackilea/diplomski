// application/json data
target.request().post(Entity.json(jsonStringDataOrPojo));

                        // application/xml data
target.request().post(Entity.xml(xmlStringDataOrPojo));

                        // text/plain data
target.request().post(Entity.entity(stringData, MediaType.TEXT_PLAIN));

                        // text/plain data 
target.request().post(Entity.text(stringData));