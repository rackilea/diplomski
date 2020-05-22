public static void main(String[] args) throws IOException {
    Ontology ontology = new Ontology();
    BufferedReader br = new BufferedReader(new FileReader("file.txt"));
    Pattern p = Pattern.compile("'(.*?)'\\('(.*?)','(.*?)'\\)"); 
    String line;
    while ((line = br.readLine()) != null) {
        Matcher m = p.matcher(line);
        if( m.matches() ) {
            String verb    = m.group(1);
            String object  = m.group(2);
            String subject = m.group(3);
            ontology.addSentence( new Sentence( verb, object, subject ) );
        }
    }

    for( String joint: ontology.getJoints() ){
        for( Integer subind: ontology.getSubjectIndices( joint ) ){
            Sentence xaS = ontology.getSentence( subind );
            for( Integer obind: ontology.getObjectIndices( joint ) ){
                Sentence yOb = ontology.getSentence( obind );
                Sentence s = new Sentence( xaS.getVerb(),
                                           xaS.getObject(),
                                           yOb.getSubject() );
                System.out.println( s );
            }
        }
    }
}