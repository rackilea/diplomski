dwr.engine.beginBatch();
Remote.methodInBatch1(params, callback1);
Remote.methodInBatch2(params, callback2);
dwr.engine.endBatch({
  timeout:3000
});