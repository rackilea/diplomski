A type is serializable and can be used in a service interface if one of the following is true:

All primitive types (int, char, boolean, etc.) and their wrapper objects are serializable by default.
An array of serializable types is serializable by extension.
A class is serializable if it meets these three requirements:
It implements either Java Serializable or GWT IsSerializable interface, either directly, or because it derives from a superclass that does.
Its non-final, non-transient instance fields are themselves serializable, and
It has a default (zero argument) constructor with any access modifier (e.g. private Foo(){} will work)