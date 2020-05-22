dockerClient = DockerClientBuilder.getInstance().build();
    //starting the container    
   CreateContainerResponse container = dockerClient.createContainerCmd("hello-world")
           .withCmd()
           .exec();
   dockerClient.startContainerCmd(container.getId()).exec();
   //stop the container 
   dockerClient.stopContainerCmd(container.getId()).exec();