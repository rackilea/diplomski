else if(user.isLocked()) {
    if(canUnlockUser(user)){
        logger.info("|*|*| Unlocking account. Account Lock Timer Over.. |*|*|*|");
        loginHistoryService.lockUserAccount(user.getUserId(), false);
    } else {
        throw new LockedException("Account is Locked");
    }       
}