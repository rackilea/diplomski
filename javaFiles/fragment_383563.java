Set mapSet = (Set) Analyser.XMLDUMP.entrySet();
        Iterator mapIterator = mapSet.iterator();

        while (mapIterator.hasNext()) {
            Map.Entry mapEntry = (Map.Entry) mapIterator.next();
            String keyValue = (String) mapEntry.getKey();
            String value = (String) mapEntry.getValue();

            Element Details = doc.createElement(keyValue);
            root.appendChild(Details);

            Element id = doc.createElement("Class");
            id.appendChild(doc.createTextNode(value));
            Details.appendChild(id);

            for (FieldAnalyser fieldAnal : Analyser.FIELDS ) {
                if(fieldAnal.getOwner().equals(value)) {

                    Element fieldFound = doc.createElement(fieldAnal.getName());
                    fieldFound.appendChild(doc.createTextNode(fieldAnal.getField()));
                    Details.appendChild(fieldFound);
                }
            }
        }