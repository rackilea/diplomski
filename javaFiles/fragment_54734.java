public interface MCarbon extends Library {
  MCarbon INSTANCE = (MCarbon) Native.loadLibrary("Carbon", MCarbon.class);
  Pointer GetCurrentEventQueue();
  int SendEventToEventTarget(Pointer inEvent, Pointer intarget);
  int RemoveEventFromQueue(Pointer inQueue, Pointer inEvent);
  void ReleaseEvent(Pointer inEvent);
  Pointer AcquireFirstMatchingEventInQueue(Pointer inQueue,NativeLong inNumTypes,EventTypeSpec[] inList, NativeLong inOptions);
  //... so on
  }