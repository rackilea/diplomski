if (storedData != null && storedRequestInfo == userRequest.requestInfo) {
    return storedData;
}

storedData = youCalculateTheRequestedData();
storedRequestInfo = userRequest.requestInfo;

return storedData;