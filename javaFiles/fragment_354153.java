java.lang.NoSuchMethodError: org.springframework.kafka.listener.KafkaMessageListenerContainer.getContainerProperties()Lorg/springframework/kafka/listener/config/ContainerProperties;
    at com.example.Foo.referenceOldClass(Foo.java:29) ~[classes/:na]
    at com.example.So53503830Application.lambda$0(So53503830Application.java:32) [classes/:na]
    at org.springframework.boot.SpringApplication.callRunner(SpringApplication.java:804) [spring-boot-2.1.0.RELEASE.jar:2.1.0.RELEASE]
    at org.springframework.boot.SpringApplication.callRunners(SpringApplication.java:794) [spring-boot-2.1.0.RELEASE.jar:2.1.0.RELEASE]
    at org.springframework.boot.SpringApplication.run(SpringApplication.java:324) [spring-boot-2.1.0.RELEASE.jar:2.1.0.RELEASE]
    at org.springframework.boot.SpringApplication.run(SpringApplication.java:1260) [spring-boot-2.1.0.RELEASE.jar:2.1.0.RELEASE]
    at org.springframework.boot.SpringApplication.run(SpringApplication.java:1248) [spring-boot-2.1.0.RELEASE.jar:2.1.0.RELEASE]
    at com.example.So53503830Application.main(So53503830Application.java:16) [classes/:na]

2018-11-28 15:02:56.962 ERROR 95564 --- [           main] o.s.b.d.LoggingFailureAnalysisReporter   : 

***************************
APPLICATION FAILED TO START
***************************

Description:

An attempt was made to call the method org.springframework.kafka.listener.KafkaMessageListenerContainer.getContainerProperties()Lorg/springframework/kafka/listener/config/ContainerProperties; but it does not exist. Its class, org.springframework.kafka.listener.KafkaMessageListenerContainer, is available from the following locations:

    jar:file:/Users/grussell/.m2/repository/org/springframework/kafka/spring-kafka/2.2.0.RELEASE/spring-kafka-2.2.0.RELEASE.jar!/org/springframework/kafka/listener/KafkaMessageListenerContainer.class

It was loaded from the following location:

    file:/Users/grussell/.m2/repository/org/springframework/kafka/spring-kafka/2.2.0.RELEASE/spring-kafka-2.2.0.RELEASE.jar


Action:

Correct the classpath of your application so that it contains a single, compatible version of org.springframework.kafka.listener.KafkaMessageListenerContainer