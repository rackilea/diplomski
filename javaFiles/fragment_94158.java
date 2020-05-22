final ContainerConfig containerConfig = ContainerConfig.builder()  
    .hostConfig(HostConfig.builder().networkMode("host").build())
    .image("helloworldjob")
    .build();
final ContainerCreation creation = docker.createContainer(containerConfig, "image");
final String id = creation.id();
try {
    docker.startContainer(id);
    final ContainerExit exit = docker.waitContainer(id);
    assertThat(exit.statusCode()).isEqualTo(0);
} finally {
    docker.removeContainer(id);
}