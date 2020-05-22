stream.flatMap(new RichFlatMapFunction<byte[], Void>() {
            CassandraConnection con = new CassandraConnection();
            int i = 0 ;

            @Override
            public void open(Configuration parameters) throws Exception {
                super.open(parameters);
                con.connect();
            }

            @Override
            public void flatMap(byte[] value, Collector<Void> out) throws Exception {

                ByteBuffer tb = ByteBuffer.wrap(value);
                np.parse(tb, ConfigHashMap, con);
            }
        });