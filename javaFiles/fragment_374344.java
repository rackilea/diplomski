kamon
{
  metrics
  {
    actor {
      filters = [
        {
          actor {
            includes = ["*"]
            excludes = ["system/*", "user/IO-*"]
          }
        },
        {
          router {
            includes = ["*"]
            excludes = ["system/*", "user/IO-*"]
          }
        },
        {
          trace {
            includes = ["*"]
            excludes = []
          }
        },
        {
          dispatcher {
            includes = ["default-dispatcher"]
            excludes = []
          }
        }
      ]
    }
  }
  statsd {
    hostname = "10.0.1.4"
    port = 8125
    flush-interval = 1 second
    max-packet-size = 1024 bytes

    includes
    {
      actor = ["*"]
      trace = ["*"]
      dispatcher = ["*"]
    }
    simple-metric-key-generator {

      application = "test.akka"
    }
  }
}