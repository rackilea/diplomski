@Bean
public IntegrationFlow pollLs(SessionFactory<LsEntry> sessionFactory) {
    return IntegrationFlows.from(() -> "foo/bar", e -> e
                .poller(Pollers.fixedDelay(5, TimeUnit.SECONDS)))
            .handle(Sftp.outboundGateway(sessionFactory, Command.LS, "payload")
                    .options(Option.RECURSIVE))
            .handle(System.out::println)
            .get();
}