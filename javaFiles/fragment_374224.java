jsRoutes.controllers.Test.duh().ajax({
  data: JSON.stringify({
    name: "Test",
    bars: [{prop1: "first"}]
  }),
  headers: {
    "Content-Type": "application/json"
  }
});