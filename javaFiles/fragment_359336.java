import com.hazelcast.client.HazelcastClient
import com.hazelcast.client.config.ClientConfig

fun main(args: Array<String>) {

    val config = ClientConfig()
    config.getNetworkConfig().addAddress("127.0.0.1:5701")
    val hazelcastInstance = HazelcastClient.newHazelcastClient(config)

    val map = hazelcastInstance.getMap<Any, Any>("Tag")

    println("=================")
    map.forEach { t, u ->
        println(" $t -> $u ")
    }
    println("=================")

    hazelcastInstance.shutdown()

}