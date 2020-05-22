public String checkQueue(String queue) {
    return jmsTemplate.browse(queue, (session, browser) -> {
        Enumeration<?> messages = browser.getEnumeration();
        int total = 0;
        while (messages.hasMoreElements()) {
            messages.nextElement();
            total++;
        }
        return String.format("Total '%d elements waiting in %s", total, queue);
    });
}