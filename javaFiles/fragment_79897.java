while (parser.nextToken() != null && !done) {
            parser.nextToken();
            String name = parser.getCurrentName();
            if (name!=null){
                if (name.equals("pressure_mb")) {
                    parser.nextToken();
                    String value = parser.getText();
                    Log.v(LOG_TAG,value);
                    result.setPressure(value);
                    break;
                }
            }
        }