curl http://localhost:9200/_nodes/process?pretty

{
  "cluster_name" : "elasticsearch",
  "nodes" : {
    "XXXXXXXXXXXXXXXXXXXXXXX" : {
      "name" : "Marrina Smallwood",
      "transport_address" : "inet[XX.XX.XX.XX:9300]",
      "host" : "MacBook-Pro-Retina.local",
      "ip" : "XX.XX.XX.XX",
      "version" : "1.1.1",
      "build" : "f1585f0",
      "http_address" : "inet[/XX.XX.XX.XX:9200]",
      "process" : {
        "refresh_interval" : 1000,
        "id" : 538,
        "max_file_descriptors" : 32768,
        "mlockall" : false
      }
    }
  }
}