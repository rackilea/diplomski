GenericContainer container = new GenericContainer("docker.elastic.co/elasticsearch/elasticsearch:6.1.1")
            .withExposedPorts(9200)
            .withEnv("discovery.type", "single-node")
            .withEnv("HTTP_PROXY", "http://127.0.0.1:3001")
            .withEnv("HTTPS_PROXY", "http://127.0.0.1:3001")
            .waitingFor(Wait.forHttp("/_cat/health?v&pretty")
                    .forStatusCode(200));