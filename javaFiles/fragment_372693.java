protected override void CompleteHandshake() // Override in your TlsClientProtocol class
  {
    // After the handshake completed, we do not have any access to the handshake data anymore
    // (see TlsClientProtocol.CleanupHandshake). Therefore we must intercept here to gather information
    YourValidationOfTheOcspResponse(mCertificateStatus);
    // mCertificateStatus holds the response. It is cleared after the following call:
    base.CompleteHandshake();
  }