import backtype.storm.Config;
import backtype.storm.LocalCluster;
import backtype.storm.topology.TopologyBuilder;

public class SampleTopology {

    /**
     * @param args
     */
    public static void main(String[] args) {

        TopologyBuilder topology=new TopologyBuilder();
        topology.setSpout("sampleSpout",new SampleSpout());
        topology.setBolt("sampleBolt",new SampleBolt()).shuffleGrouping("sampleSpout");

        Config conf = new Config();
        conf.setDebug(true);

        LocalCluster cluster=new LocalCluster();
        cluster.submitTopology("test", conf, topology.createTopology());


    }

}