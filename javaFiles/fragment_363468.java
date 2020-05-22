try {
    Class stemClass = Class.forName("org.tartarus.snowball.ext." +"english"+ "Stemmer");
    SnowballStemmer stemmer = (SnowballStemmer) stemClass.newInstance();
} catch(Exception e){
    //Do Something
} finally {
    //Do Something
}