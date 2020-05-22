public void doProcess() throws ServiceException {
   ...
}

public void processor() {
  try {
    doProcess();
  } catch (BadRequestException e) {
    // Handle specific exception
  } catch (ServiceUnreachableException e) {
    // etc
  } catch (InvalidApiKeyException e) {
    // ...
  } catch (ServiceException e) {
    // fallback for any other flavor of ServiceException
    // ...
  }
}