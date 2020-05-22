List<Integer> followersCount = collectionUserInfo.aggregate(
            Arrays.asList(Aggregates.project(Projections.computed(
                    "followersCount",
                    Projections.computed("$size", "$followers"))
                    )
            ))
   .map(follower -> follower.getInteger("followersCount"))
   .into(new ArrayList<>());