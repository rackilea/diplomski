String cronAttribute = taskElement.getAttribute("cron");
if (StringUtils.hasText(cronAttribute)) {
    cronTaskMap.put(runnableBeanRef, cronAttribute);
}
else {
    String fixedDelayAttribute = taskElement.getAttribute("fixed-delay");
    if (StringUtils.hasText(fixedDelayAttribute)) {
        fixedDelayTaskMap.put(runnableBeanRef, fixedDelayAttribute);
    }
    else {
        String fixedRateAttribute = taskElement.getAttribute("fixed-rate");
        if (!StringUtils.hasText(fixedRateAttribute)) {
            parserContext.getReaderContext().error(
                    "One of 'cron', 'fixed-delay', or 'fixed-rate' is required",
                    taskElement);
            // Continue with the possible next task element
            continue;
        }
        fixedRateTaskMap.put(runnableBeanRef, fixedRateAttribute);
    }
}