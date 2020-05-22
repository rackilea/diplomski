ValidationEventCollector vec = new ValidationEventCollector();

        SchemaFactory sf = SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI);

        URL xsdURL = getClass().getResource("/xsd/" + xsd);
        Schema schema = sf.newSchema(xsdURL);

        //You should change your jaxbContext here for your stuff....
        Unmarshaller um = (getJAXBContext(NotificationReponseEnum.NOTIFICATION, notificationWrapper.getEnteteNotification().getTypeNotification()))
                .createUnmarshaller();
        um.setSchema(schema);

        try {

            StringReader reader = new StringReader(xml);
            um.setEventHandler(vec);
            um.unmarshal(reader);

        } catch (javax.xml.bind.UnmarshalException ex) {

            if (vec != null && vec.hasEvents()) {
                erreurs = new ArrayList<MessageErreur>();
                for (ValidationEvent ve : vec.getEvents()) {
                    MessageErreur erreur = new MessageErreur();
                    String msg = ve.getMessage();
                    ValidationEventLocator vel = ve.getLocator();
                    int numLigne = vel.getLineNumber();
                    int numColonne = vel.getColumnNumber();
                    erreur.setMessage(msg);
                    msgErreur.setCode(ve.getSeverity())
                    erreur.setException(ve.getLinkedException());
                    erreur.setPosition(numLigne, numColonne);
                    erreurs.add(erreur);

                    logger.debug("Erreur de validation xml" + "erreur : " + numLigne + "." + numColonne + ": " + msg);
                }
            }

        }