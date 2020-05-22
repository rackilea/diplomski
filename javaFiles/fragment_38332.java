<c:set var="endIndex" 
    value="${
        (fn:length(offeredService) - fn:length(serviceHistory) - 1) < 0 ? 
        fn:length(offeredService)
        : fn:length(offeredService) - fn:length(serviceHistory) - 1
    }
"/>