else if (user.isLocked()) {
    if (DateUtil
            .addHours(user.getLockedTime(), Integer.parseInt(
                    messageSource.getMessage(Constants.UNLOCK_ACCOUNT_AFTER_XX_HOURS, null, "24", null)))
            .compareTo(DateUtil.getCurrentDateTime()) < 0 && isPasswordValid) {
        logger.info("|*|*| Unlocking account. Account Lock Timer Over.. |*|*|*|");
        loginHistoryService.lockUserAccount(user.getUserId(), false);
}