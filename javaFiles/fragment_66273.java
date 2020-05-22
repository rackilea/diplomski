SecurityBindingElement sec =
                SecurityBindingElement.CreateMutualCertificateBindingElement(
                  MessageSecurityVersion.WSSecurity10WSTrustFebruary2005WSSecureConversationFebruary2005WSSecurityPolicy11BasicSecurityProfile10, false);
X509SecurityTokenParameters x509Params = new X509SecurityTokenParameters();
x509Params.X509ReferenceStyle = X509KeyIdentifierClauseType.IssuerSerial;
((AsymmetricSecurityBindingElement) sec).InitiatorTokenParameters = x509Params;