package com.message.helper;

import com.message.pojo.Entity;

public aspect ValidationAspect {
  before(Entity entity) :
    call(public * Processor.process(Entity)) &&
    args(entity) &&
    target(MessageProcessor)
  {
    ValidationUtil validation = new ValidationUtil();
    validation.validate(entity);
  }
}