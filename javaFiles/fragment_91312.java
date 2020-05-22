73:    try {
76:        inputStream = getClass().getResourceAsStream(propFileName);
77
78:        if (inputStream != null) {
80:        } else {
82:        }
83:        
88:    } finally {
89:            inputStream.close(); //Might be null -> cause of your error
90:    }