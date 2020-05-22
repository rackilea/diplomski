final GenericRawResults<Coupon> results = couponDao.queryRaw("SELECT "
                + "product_table.product_id AS id, "
                + "product_table.store_id AS storeId "
                + " FROM coupon_table "
                + "JOIN product_table ON coupon_table.store_id = product_table.store_id "
                + "WHERE product_table.store_id = 1", new RawRowMapper<Coupon>() {

                    @Override
                    public Coupon mapRow(String[] columnNames, String[] resultColumns) throws SQLException {
                        final Integer productId = Integer.parseInt(resultColumns[0]);
                        final Integer storeId = Integer.parseInt(resultColumns[1]);

                        final Product product = new Product();
                        product.setId(productId);
                        product.setStoreId(storeId);

                        final Coupon coupon = new Coupon();
                        coupon.setProduct(product);
                        return coupon;
                    }

                });

            final Coupon coupon = results.getResults().get(0);
            final Product product = coupon.getProduct();
            System.out.println("Product id is " + product.getId() + " , Store id is " + product.getStoreId());