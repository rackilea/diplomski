remotelookup {
  include "common"

  akka {
    remote.netty.port = 2500
    cluster.nodename = "n1"
  }
}