public OperationFormMapper(ModelMapper modelMapper) {
        this.modelMapper = modelMapper;

        Converter<OperationForm, Operation> converter = context -> {
            OperationForm src = context.getSource();
            Operation dest = new Operation();

            final LocalDateTime NOW = LocalDateTime.now();
            dest.setOperationKey(OperationKey.of(src.getLegalEntityId(), src.getEmployeeId(), NOW));
            dest.setIndividualId(src.getIndividualId());
            dest.setKey(src.getLegalEntityId() + "_" + src.getEmployeeId() + "_" + NOW);

            return dest;
        };

        this.modelMapper.addConverter(converter);
    }