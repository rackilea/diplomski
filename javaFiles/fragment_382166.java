from("mock:some-route")
  .split().method("splitterBean", "split")
  .to("seda:your-seda-queue?waitForTaskToComplete=Always&timeout=0");

from("seda:your-seda-queue?waitForTaskToComplete=Always&timeout=0")
  .to(ExchangePattern.InOut, "jms:some-thing");