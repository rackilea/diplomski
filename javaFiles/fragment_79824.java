class Result {
  protected boolean winner;
  ..
};

class ThrowingResult extends Result{
  protected float range;
  ..
}

class SprintResult extends Result{
  protected double timeToFinishInMilliseconds;
  protected int finalPosition;
  ..
}

class AthleticCompetitionResults{
  private Athletic athletic;

  private SprintResult resultM100;
  private SprintResult resultLongJump;

  private ThrowingResult javelin;
  private ThrowingResult shotPut;

  private Result wrestling;
  ...
}