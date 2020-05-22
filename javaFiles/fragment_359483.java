if (contractors != null) {
    String currentManager = null;

    for (User contractor : contractors) {
        String contractorManager = contractor.getManager();

        if (!contractorManager.equals(currentManager) {
            // a new manager
            if (currentManager != null) {
                sendEmail(body.toString());
                body.setLength(0);
            }
            currentManager = contractorManager;
        }
        //build body of email ...
    }

    // send the email for the last manager
    sendEmail(body.toString());
}