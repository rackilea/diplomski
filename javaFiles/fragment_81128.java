// Calls expensiveOperation & builds log string:
logger.trace("Some long running operation returned "+expensiveOperation())

// Calls expensiveOperation, but does not build log string:
logger.trace("Some long-running operation returned {}", expensiveOperation());

// Does not call expensiveOperation, nor builds log string:
logger.trace("Some long-running operation returned {}", () -> expensiveOperation());