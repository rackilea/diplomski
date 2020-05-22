eureka:
  instance:
    hostname: localhost
    ip-address: 127.0.0.1
  server:
    enable-self-preservation: false
  client:
    registerWithEureka: false
    fetchRegistry: false
  serviceUrl:
    defaultZone: http://${eureka.instance.hostname}:${server.port}/eureka/