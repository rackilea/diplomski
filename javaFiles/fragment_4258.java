if (forceReadCommitted) {

            this.session.doWork(new Work() {

                @Override
                public void execute(Connection connection) throws SQLException {

                    connection.setTransactionIsolation(2);
                }
            });
        }