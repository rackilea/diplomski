instanceObj.final_doc_type = 
    Optional.ofNullable(instance)
      .map(Instance::getFinalDocument)
      .map(Document::getValue)
      .map(Value::getType)
      .map(Type::getValue)
      .orElse(null);