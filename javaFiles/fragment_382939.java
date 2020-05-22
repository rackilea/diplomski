// get new block from namenode.
if (stage == BlockConstructionStage.PIPELINE_SETUP_CREATE) {
  if(LOG.isDebugEnabled()) {
    LOG.debug("Allocating new block");
  }
  setPipeline(nextBlockOutputStream());
  initDataStreaming();
}