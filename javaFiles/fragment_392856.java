@Configuration
public class IntegrationConfiguration {

    private final ApiGateConfig apiGateConfig;

    IntegrationConfiguration(ApiGateConfig apiGateConfig) {
        this.apiGateConfig = apiGateConfig;
    }

    @Bean("marketingCategory")
    MessageChannel marketingCategory() {
        return new PublishSubscribeChannel();
    }

    @Bean
    MessageChannel marketingCategoryPoller() {
        return new DirectChannel();
    }

    @Bean
    MessageChannel marketingCategoryPollerNextPage() {
        return new DirectChannel();
    }

    @Bean
    @InboundChannelAdapter(channel = "marketingCategoryPoller", poller = @Poller(fixedDelay = "15000"))
    public MessageSource<RestPageImpl<MarketingCategory>> marketingCategoryPollerMessageSource() {
        return () -> makeTriggeringMessage(0);
    }

    /**
     * Build a gateway triggering message
     */
    private Message<RestPageImpl<MarketingCategory>> makeTriggeringMessage(int page) {
        return MessageBuilder.withPayload(new RestPageImpl<MarketingCategory>())
                .setHeader("Host", "eclinic")
                .setHeader("page", page)
                .build();
    }

    @Bean
    @ServiceActivator(inputChannel = "marketingCategoryPoller")
    public MessageHandler marketingCategoryOutboundGateway(@Qualifier("marketingCategory") MessageChannel channel) {

        String uri = apiGateConfig.getUri() + "/marketingCategories?page={page}";

        //the type of the payload
        ParameterizedTypeReference<RestPageImpl<MarketingCategory>> type = new ParameterizedTypeReference<>() {
        };

        //page number comes from the message
        SpelExpressionParser expressionParser = new SpelExpressionParser();
        var uriVariables = new HashMap<String, Expression>();
        uriVariables.put("page", expressionParser.parseExpression("headers.page"));

        HttpRequestExecutingMessageHandler handler = new HttpRequestExecutingMessageHandler(uri);
        handler.setHttpMethod(HttpMethod.GET);
        handler.setExpectedResponseTypeExpression(new ValueExpression<>(type));
        handler.setOutputChannel(channel);
        handler.setUriVariableExpressions(uriVariables);

        return handler;
    }

    @Bean
    @ServiceActivator(inputChannel = "marketingCategory")
    public MessageHandler marketingCategoryHandler() {
        return (msg) -> {
            var page = (RestPageImpl<MarketingCategory>) msg.getPayload();

            System.out.println("Page #" + page.getNumber());

            page.getContent().forEach(c -> System.out.println(c.getMarketingCategory()));

        };
    }

    @Filter(inputChannel = "marketingCategory", outputChannel = "marketingCategoryPollerNextPage")
    public boolean marketingCategoryPaginationFilter(RestPageImpl<MarketingCategory> page) {
        return !page.isLast();
    }

    @Bean
    @Transformer(inputChannel = "marketingCategoryPollerNextPage", outputChannel = "marketingCategoryPoller")
    HeaderEnricher incrementPage() {
        Map<String, HeaderValueMessageProcessor<?>> headersToAdd = new HashMap<>();
        Expression expression = new SpelExpressionParser().parseExpression("headers.page+1");

        var valueProcessor = new ExpressionEvaluatingHeaderValueMessageProcessor<>(expression, Integer.class);
        valueProcessor.setOverwrite(true);

        headersToAdd.put("page", valueProcessor);
        return new HeaderEnricher(headersToAdd);
    }
}