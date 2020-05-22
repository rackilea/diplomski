@Bean
public UnicastReceivingChannelAdapter udpInboundAdapter() {
        UnicastReceivingChannelAdapter unicastReceivingChannelAdapter = new UnicastReceivingChannelAdapter(1111);
        unicastReceivingChannelAdapter.setOutputChannel(udpChannel());
        return unicastReceivingChannelAdapter;
}