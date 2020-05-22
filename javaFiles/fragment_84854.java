TransportOptions options = HttpTransportOptions.newBuilder().setHttpTransportFactory(new HttpTransportOptions.DefaultHttpTransportFactory()).build();
GoogleCredentials credential = GoogleCredentials.getApplicationDefault();
BigQuery service = BigQueryOptions.newBuilder().setProjectId(YOUR_PROJECT_ID)
                        .setTransportOptions(options)
                        .setCredentials(credential)
                        .build()
                        .getService();