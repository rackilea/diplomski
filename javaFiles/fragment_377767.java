public class ProxySpout extends BaseRichSpout{

    int port;

    public ProxySpout(int port){
        this.port=port;
    }

    @Override
    public void open(Map conf, TopologyContext context, SpoutOutputCollector collector)  { 
        //new ServerSocket
    }

    @Override
    public void nextTuple() {

    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer declarer) {

    }
}