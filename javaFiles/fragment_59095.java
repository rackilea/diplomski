public static void main( String[] args )
        {
            ClientConfiguration clientConfig = new ClientConfiguration();

            AWSLogsClientBuilder builder = AWSLogsClientBuilder.standard();

            AWSLogs logsClient = builder.withCredentials( new AWSStaticCredentialsProvider( new ProfileCredentialsProvider().getCredentials() ) )
                    .withRegion( Regions.AP_SOUTHEAST_2 )
                    .withClientConfiguration( clientConfig ).build();

            DescribeLogStreamsRequest describeLogStreamsRequest = new DescribeLogStreamsRequest().withLogGroupName( "FlowLogs_GroupName"  );
            DescribeLogStreamsResult describeLogStreamsResult = logsClient.describeLogStreams( describeLogStreamsRequest );

            for ( LogStream logStream : describeLogStreamsResult.getLogStreams() )
            {
                GetLogEventsRequest getLogEventsRequest = new GetLogEventsRequest()
                        .withStartTime( 1531231200000L )
                        .withEndTime( 1531576800000L )
                        .withLogGroupName( "FlowLogs_GroupName" )
                        .withLogStreamName( logStream.getLogStreamName() );

                GetLogEventsResult result = logsClient.getLogEvents( getLogEventsRequest );

                result.getEvents().forEach( outputLogEvent -> {
                    System.out.println( outputLogEvent.getMessage() );
                } );

            }
        }