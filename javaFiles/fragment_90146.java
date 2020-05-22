#set($paramName = $helper.getParamName($field, $project))
public ##
#if($field.modifierStatic)
    static ##
#end
#if($StringUtil.split($field.type, "<").get(0).equals("com.google.common.base.Optional"))    
    #set($paramSignature = $StringUtil.trimEnd($StringUtil.substringAfter($field.type, "<"), ">"))
    #set($fieldAssignment = "Optional.fromNullable(" + $paramName + ")") 
#else
    #set($paramSignature = $field.type)
    #set($fieldAssignment = $paramName)
#end
void set$StringUtil.capitalizeWithJavaBeanConvention($StringUtil.sanitizeJavaIdentifier($helper.getPropertyName($field, $project)))($paramSignature $paramName) { 
#if ($field.name == $paramName)
    #if (!$field.modifierStatic)
        this.##
    #else
        $classname.##
    #end
#end
$field.name = $fieldAssignment;
}