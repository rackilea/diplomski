public Job loadRecipients() {
    return jobs.get("loadRecipients")
            .start(truncateRecipientsStep())
            .next(injectStaticAnalyticsUserCategoryStep())
            .next(loadRecipients())
            .preventRestart()
            .build();
}

public Step injectInternalEmailRecipientStep() {
    return stepBuilderFactory.get("injectAnalyticsEmailUserCategoryStep")
            .tasklet(injectInternalEmailRecipientTasklet())
            .build();
}

public Tasklet injectInternalEmailRecipientTasklet() {
    return new InjectInternalEmailRecipientTasklet(recipientRepository);
}