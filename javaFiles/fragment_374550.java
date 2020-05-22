Runnable runnable = new Runnable() {
        public void run() {
            //DynamoDB calls go here

            Outfit selectedOutfit = mapper.load(Outfit.class, "22");

            selectedOutfit.getItemOne_id();
            selectedOutfit.getItemOne_detail();
            selectedOutfit.getItemOne_price();
            new Handler(Looper.getMainLooper()).post(new Runnable() {
                @Override
                public void run() {
                    itemOneID.setText(selectedOutfit.getItemOne_id());
                    itemOneDetail.setText(selectedOutfit.getItemOne_detail());
                    itemOnePrice.setText(selectedOutfit.getItemOne_price());
                }
            });
            /*
            DynamoDBQueryExpression queryExpression = new DynamoDBQueryExpression()
                    .withHashKeyValues(outfitToFind)
                    .withConsistentRead(false);

            PaginatedQueryList<Outfit> result = mapper.query(Outfit.class, queryExpression);
            result.
            */
        }
    };