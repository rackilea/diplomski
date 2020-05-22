The Synthetic attribute is a fixed-length attribute in the attributes
table of a ClassFile, field_info, or method_info structure (§4.1,
§4.5, §4.6). A class member that does not appear in the source code
must be marked using a Synthetic attribute, or else it must have its
ACC_SYNTHETIC flag set. The only exceptions to this requirement are
compiler-generated methods which are not considered implementation
artifacts, namely the instance initialization method representing a
default constructor of the Java programming language (§2.9), the class
initialization method (§2.9), and the Enum.values() and Enum.valueOf()
methods.


The Synthetic attribute was introduced in JDK release 1.1 to support 
nested classes and interfaces.

The Synthetic attribute has the following format:

Synthetic_attribute {
    u2 attribute_name_index;
    u4 attribute_length;
}

The items of the Synthetic_attribute structure are as follows:

attribute_name_index

    The value of the attribute_name_index item must be a valid index into
    the constant_pool table. The constant_pool entry at that index must be
    a CONSTANT_Utf8_info (§4.4.7) structure representing the string "Synthetic".

attribute_length

    The value of the attribute_length item is zero.