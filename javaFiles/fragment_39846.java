while(xer.hasNext()) {
        XMLEvent xe = xer.peek(); // CHANGE
        if(xe.isStartElement()) {
            if(xe.asStartElement().getName().getLocalPart().equals("mav")) {
                // if(xer.peek() != null) {
                    mavByXml.unmarshal(xer, MavType.class).getValue();
                // }
                mavv++;
            }
        }
        // NEW
        if(xer.hasNext()) {
           xer.nextTag();
        }
    }