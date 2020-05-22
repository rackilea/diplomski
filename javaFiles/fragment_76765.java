public void characters(char ch[], int start, int length) throws SAXException {
    for(int i=start, end = start+ length; i < end; i++) {
       if(ch[i] <= ' ') {
          // check if it is a white space
       }
    }
}