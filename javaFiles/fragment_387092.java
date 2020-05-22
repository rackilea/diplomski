RecommenderIRStatsEvaluator user_eval = new GenericRecommenderIRStatsEvaluator();
    RecommenderBuilder user_rb = new RecommenderBuilder() 
    {
    @Override
        public Recommender buildRecommender(DataModel model) throws TasteException 
        {
            UserSimilarity user_ll_sim = new LogLikelihoodSimilarity(model);
            UserNeighborhood user_ll_nbhd = new NearestNUserNeighborhood(5, user_ll_sim, model);
            return new GenericUserBasedRecommender(model, user_ll_nbhd, user_ll_sim);
        }
    };

    IRStatistics user_ll_stats = user_eval.evaluate(user_ll_rb, null, model, null, 2, GenericRecommenderIRStatsEvaluator.CHOOSE_THRESHOLD, 0.8);
    System.out.println(user_ll_stats.getPrecision()+" "+user_ll_stats.getRecall());