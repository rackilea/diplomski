RestResponseStatus expectedRespStatus = createMock(RestResponseStatus.class);
ParameterValidator validator = createMock(ParameterValidator.class);
validator.isValid();
expectLastCall().andReturn(false);
validator.createErrorResponseStatus().andReturn(expectedRespStatus);
expectLastCall();
replay(validator);
replay(expectedRespStatus);

RestResponseStatus respStatus = this.validate(validator);
assertSame(expectedRespStatus, respStatus);
verify(validator);