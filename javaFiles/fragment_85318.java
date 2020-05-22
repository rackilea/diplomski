public Worker( 
         com.amazonaws.services.kinesis.clientlibrary.interfaces.IRecordProcessorFactory recordProcessorFactory, 
         KinesisClientLibConfiguration config, 
         AmazonKinesis kinesisClient, 
         AmazonDynamoDB dynamoDBClient, 
         AmazonCloudWatch cloudWatchClient, 
         ExecutorService execService) { 
     this(recordProcessorFactory, config, kinesisClient, dynamoDBClient, 
             getMetricsFactory(cloudWatchClient, config), execService); 
     if (config.getRegionName() != null) { 
         Region region = RegionUtils.getRegion(config.getRegionName()); 
         cloudWatchClient.setRegion(region); 
         LOG.debug("The region of Amazon CloudWatch client has been set to " + config.getRegionName()); 
     } 
 }