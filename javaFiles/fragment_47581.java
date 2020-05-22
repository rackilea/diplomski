LinkedHashSet<String> tweets_set    = new LinkedHashSet<String>(tweets);
                System.out.println("Before: "+tweets);

                //replace stopword
                for (String word : tweets_set) {
                    if (stopwords.contains(word)) {
                    tweets.remove(word);
                    }
                }