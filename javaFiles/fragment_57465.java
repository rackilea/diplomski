@RequestMapping(value = "/async", method = RequestMethod.GET)
    public DeferredResult<ResponseEntity<String>> doAsync() {

      DeferredResult<ResponseEntity<String>> result = new DeferredResult<>();
      this.asyncService.asyncMethodOnAService().whenComplete((serviceResult, throwable) -> result.setResult(ResponseEntity.ok(serviceResult)));

      return result;
    }