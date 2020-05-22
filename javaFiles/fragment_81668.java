public ##
#if($field.modifierStatic)
  static ##
#end
$field.type ##
#set($name = $StringUtil.capitalizeWithJavaBeanConvention($StringUtil.sanitizeJavaIdentifier($helper.getPropertyName($field, $project))))
#set($name = $StringUtil.decapitalize($name))
##
${name}() {
  return $field.name;
}