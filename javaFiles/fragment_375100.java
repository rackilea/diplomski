if(isUseEvent())
    if(safeBreak(target,event.getPlayer(),physics))
        subject.sendBlockChange(target.getLocation(), 0, (byte)0);
    else {
        target.setTypeId(0,physics);
        subject.sendBlockChange(target.getLocation(), 0, (byte)0);
    }