cluster:
   name: elasticsearch # would be ${es.cluster.name}

 network:
   host: localhost 
   transport: 
     tcp:
       port: 9301 # would be ${es.network.transport.tcp.port}