ParameterValidator validator = createMock(ParameterValidator.class);
validator.isValid();
expectLastCall().andReturn(false);
replay(validator);

this.validate(validator);
verify(validator);