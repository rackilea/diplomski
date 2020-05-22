AtomicBoolean active = new AtomicBoolean(true);

while(active.getOpaque())
{
    //loop-code (very fast)
}


//shutdown-thread, called once after a few weeks

active.setOpaque(false);