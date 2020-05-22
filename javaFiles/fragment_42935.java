class MyClass 
 {
    public static void remove_stopwords(String[] query, String[] stopwords) {

        A: for (int i = 0; i < query.length; i++) {
            //iterate through all stopwords
            B: for (int j = 0; j < stopwords.length; j++) {
                    //if stopwords found break
                    C: if (query[i].equals(stopwords[j])) { 
                        break B;
                    } 
                    else { 
                        // if this is the last stopword print it
                        // it means query[i] does not equals with all stopwords
                        if(j==stopwords.length-1)
                        {
                           System.out.println(query[i]);
                        }
                    }
                }
            } 
        }
    }