if(isUseEvent())
    safeBreak(target,event.getPlayer(),physics);
else {
    target.setTypeId(0,physics);
    subject.sendBlockChange(target.getLocation(), 0, (byte)0);
}