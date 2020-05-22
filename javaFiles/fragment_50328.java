AnnotationCollector::ID
AnnotationCollector::annotation_index(const ClassLoaderData* loader_data,
                                      const Symbol* name) {
  const vmSymbols::SID sid = vmSymbols::find_sid(name);
  // Privileged code can use all annotations.  Other code silently drops some.
  const bool privileged = loader_data->is_the_null_class_loader_data() ||
                          loader_data->is_platform_class_loader_data() ||
                          loader_data->is_anonymous();
  switch (sid) {
...
    case vmSymbols::VM_SYMBOL_ENUM_NAME(jdk_internal_vm_annotation_Contended_signature): {
      if (_location != _in_field && _location != _in_class) {
        break;  // only allow for fields and classes
      }
      if (!EnableContended || (RestrictContended && !privileged)) {
        break;  // honor privileges
      }
      return _jdk_internal_vm_annotation_Contended;
    }