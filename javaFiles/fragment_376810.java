public Predicate createPredicate(DataEntity dataEntity) {
    QDataEntity qDataEntity = QDataEntity.dataEntity;
    BooleanBuilder booleanBuilder = new BooleanBuilder();
    if (!StringUtils.isEmpty(dataEntity.getCnsiConsumerNo())) {
      booleanBuilder
        .or(qDataEntity.cnsiConsumerNo.contains(dataEntity.getCnsiConsumerNo()));
    }
    if (!StringUtils.isEmpty(dataEntity.getCnsiMeterNo())) {
      booleanBuilder.or(qDataEntity.cnsiMeterNo.contains(dataEntity.getCnsiMeterNo()));
    }

    return booleanBuilder.getValue();
  }