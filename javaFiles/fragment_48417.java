JAXBContext context = JAXBContext.newInstance( Axle.class, PressurizedTire.class );
    Unmarshaller unmarshaller = context.createUnmarshaller();

    String xml = "<axle><tire><width>2.0</width><radius>1.5</radius></tire><tire><width>2.5</width><radius>1.5</radius></tire></axle>";
    Axle axle = (Axle) unmarshaller.unmarshal( new StringReader( xml ) );

    List<Tire> pressurizedTires = new ArrayList<>();
    for ( Tire tire : axle.tires )
    {
        pressurizedTires.add( new PressurizedTire( tire, 1.0 ) );
    }
    axle.tires = pressurizedTires;

    Marshaller marshaller = context.createMarshaller();
    marshaller.setProperty( Marshaller.JAXB_FORMATTED_OUTPUT, true );
    marshaller.marshal( axle, System.out );