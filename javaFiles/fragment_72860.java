booleab isValidRequest=false;
     String     requestData; // data to validate
     String str; //schema 

            JsonNode requestDataJsonNode = com.github.fge.jackson.JsonLoader.fromString(requestData);       
            final JsonNode schemaNode = JsonLoader.fromString(str);
    //      final JsonNode schemaNode=JsonLoader.fromResource("jsonschema.json"); for your query
    //
            final JsonSchemaFactory factory = JsonSchemaFactory.byDefault();
            JsonValidator validator = factory.getValidator();        
            ProcessingReport processingReport=  validator.validate(schemaNode, requestDataJsonNode); 
            if(processingReport!=null)
            {
                isValidRequest=processingReport.isSuccess();
            }

            } catch (Exception e) {

            }