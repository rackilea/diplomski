version: "3.4"

networks:
  smartdeploy_evo:
    external: true

volumes:
  consul:

services:

  consul:
    image: consul:0.9.3
    volumes:
      - consul:/consul
    ports:
      - target: 8500
        published: 8500
        mode: host
    networks:
      smartdeploy_evo:
        aliases:
          - consul.cluster
    environment:
      - 'CONSUL_LOCAL_CONFIG={ "skip_leave_on_interrupt": true,
      "data_dir":"/consul/data",
      "server":true }'
      - CONSUL_BIND_INTERFACE=eth0
    command: agent -ui -data-dir /consul/data -server -client 0.0.0.0 -bootstrap-expect=1 -retry-join consul.cluster
    deploy:
      endpoint_mode: dnsrr
      mode: global
      placement:
        constraints: [node.role ==  manager]

  consul_client:
    image: consul:0.9.3
    volumes:
      - consul:/consul
    networks:
      smartdeploy_evo:
        aliases:
          - consul.client.cluster
    environment:
      - 'CONSUL_LOCAL_CONFIG={ "skip_leave_on_interrupt": true,
      "data_dir":"/consul/data" }'
      - CONSUL_BIND_INTERFACE=eth0
    command: agent -ui -data-dir /consul/data -client 0.0.0.0 -retry-join consul.cluster
    deploy:
      endpoint_mode: dnsrr
      mode: global
      placement:
        constraints: [node.role !=  manager]

  consul_registrator:
    image: gliderlabs/registrator:master
    command: -internal consul://consul.cluster:8500
    volumes:
      - /var/run/docker.sock:/tmp/docker.sock
    networks:
      - smartdeploy_evo
    deploy:
      mode: global