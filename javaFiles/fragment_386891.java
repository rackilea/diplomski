public static Thread.State toThreadState(int paramInt)
{
 if ((paramInt & 0x4) != 0)
   return Thread.State.RUNNABLE;
 if ((paramInt & 0x400) != 0)
   return Thread.State.BLOCKED;
 if ((paramInt & 0x10) != 0)
   return Thread.State.WAITING;
 if ((paramInt & 0x20) != 0)
   return Thread.State.TIMED_WAITING;
 if ((paramInt & 0x2) != 0)
   return Thread.State.TERMINATED;
 if ((paramInt & 0x1) == 0) {
   return Thread.State.NEW;
 }
 return Thread.State.RUNNABLE;
}