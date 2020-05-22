public class WebSocketBolt extends BaseBasicBolt {
    private transient ProducerTemplate producerTemplate;

    @Override
    public void execute(Tuple input, BasicOutputCollector basicOutputCollector) {
        Status s = (Status) input.getValueByField("tweet");
        producerTemplate.sendBody("direct:main", s.getText());
    }

    @Override
    public void declareOutputFields(OutputFieldsDeclarer outputFieldsDeclarer) {

    }

    @Override
    public void prepare(Map stormConf, TopologyContext context) {
        super.prepare(stormConf, context);
        CamelContext producerTemplate = new RouteStarter().buildRoute();
        this.producerTemplate = producerTemplate.createProducerTemplate();
    }
}