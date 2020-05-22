interface ManagerFactory {
  Manager createManager(int managerId);
}
interface ShiftFactory {
  Shift createShift(int managerId, int shiftId);
}
interface WorkerFactory { // The two methods here might be difficult to automate.
  Worker createWorkerA(int managerId, int shiftId, int workerId);
  Worker createWorkerB(int managerId, int shiftId, int workerId);
}

class Manager {
  @Inject ShiftFactory shiftFactory;  // set by Guice, possibly in constructor
  private final int managerId;        // set in constructor

  Shift createShift(int shiftId) {
    shiftFactory.createWorkerA(this.managerId, shiftId);  // or B?
  }
}

class Shift {
  @Inject WorkerFactory workerFactory;  // set by Guice, possibly in constructor
  private final int managerId;          // set in constructor
  private final int shiftId;            // set in constructor

  Worker createWorker(int workerId) {
    shiftFactory.createShift(this.managerId, this.shiftId, workerId);
  }
}