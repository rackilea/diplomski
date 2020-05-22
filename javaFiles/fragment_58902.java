@Configuration
@EnableIntegration
public class IntegrationConfig {
    ...

    @Bean
    public IntegrationFlow imapIdleFlow() {
        return IntegrationFlows
                .from(Mail.imapIdleAdapter("imap://user:pw@localhost:" + imapIdleServer.getPort() + "/INBOX")
                        .autoStartup(true)
                        .searchTermStrategy(this::fromAndNotSeenTerm)
                        .userFlag("testSIUserFlag")
                        .javaMailProperties(p -> p.put("mail.debug", "false")
                                .put("mail.imap.connectionpoolsize", "5"))
                        .shouldReconnectAutomatically(false)
                        .headerMapper(mailHeaderMapper()))
                .channel(MessageChannels.queue("imapIdleChannel"))
                .get();
    }

    @Bean
    public HeaderMapper<MimeMessage> mailHeaderMapper() {
        return new DefaultMailHeaderMapper();
    }

    private SearchTerm fromAndNotSeenTerm(Flags supportedFlags, Folder folder) {
        try {
            FromTerm fromTerm = new FromTerm(new InternetAddress("bar@baz"));
            return new AndTerm(fromTerm, new FlagTerm(new Flags(Flags.Flag.SEEN), false));
        }
        catch (AddressException e) {
            throw new RuntimeException(e);
        }

    }
}