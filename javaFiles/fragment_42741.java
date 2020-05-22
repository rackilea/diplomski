List<ResultSetFuture> futuresList = new ArrayList<>( /*Map size*/);
        for (/* iterating over a Map*/) {
            key = entry.getKey();
            String query = "SELECT id,desc,category FROM products where id=?";
            futuresList.add( session.executeAsync( query, key ) );
        }

        ListenableFuture<List<ResultSet>> allFuturesResult = Futures.allAsList( futuresList );
        List<Product> products = new ArrayList<>();
        try {
            final List<ResultSet> resultSets = allFuturesResult.get();
            for ( ResultSet rs : resultSets ) {
                if ( null != rs ) {
                    Row row = rs.one();
                    if (row != null) {
                        Product product = new Product();
                        product.setId(row.getString("id"));
                        product.setDesc(row.getString("desc"));
                        product.setCategory(row.getString("category"));

                        products.add(product);
                    }
                }
            }
        } catch ( InterruptedException | ExecutionException e ) {
            System.out.println(e);
        }
        System.out.println("Product List : " + products);