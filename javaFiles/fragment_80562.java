Optional<ResponseEntity<?>> validationError = OptionalHelper.findFirstPresent(
            () -> requestValidator.handleOperationError(bodyParams, myHandler, serviceInstance, null),
            () -> requestValidator.checkRequestOther(serviceInstance, bodyParams, instanceAction),
            () -> requestValidator.checkSomeWeird(serviceInstance, instanceAction),
            () -> requestValidator.conflictExists(instanceAction, serviceInstance));

    if (validationError.isPresent()) {
        return validationError.get();
    }