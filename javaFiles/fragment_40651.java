goog.provide('app.incrementaldom'); // assures creation of namespace
goog.require("incrementaldom");

goog.scope(function() {
  var module = goog.module.get("incrementaldom");
  var ns = app.incrementaldom;
  app.incrementaldom.patch = module.patch;
});

goog.exportSymbol("app.incrementaldom", app.incrementaldom);