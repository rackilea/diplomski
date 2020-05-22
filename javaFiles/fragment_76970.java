EmailMessage msg = new EmailMessage(exchangeService);
                msg.setSubject("Ews api code....");        
                msg.setBody(MessageBody.getMessageBodyFromText("** Email with classification using EWS Java API."));
                msg.setFrom(new EmailAddress("some1@test.com");
                msg.getToRecipients().add("some2@test.com");


            // Define the extended property
            ExtendedPropertyDefinition extPropDef = new ExtendedPropertyDefinition(DefaultExtendedPropertySet.InternetHeaders, "x-iccategory", MapiPropertyType.String);

            // Stamp the extended property with value on a message. 2- Restricted
            msg.setExtendedProperty(extendedPropertyDefinition, "2");

            msg.send();