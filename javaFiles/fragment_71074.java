InputStream IS;
IS = SomeClass.class.getResourceAsStream("Root.txt"); // Not OK

IS = SomeClass.class.getResourceAsStream("/Root.txt"); // OK

IS = SomeClass.class.getResourceAsStream("/MyData.txt"); // Not OK

IS = SomeClass.class.getResourceAsStream("MyData.txt"); // OK

IS = SomeClass.class.getResourceAsStream("/SomePackage/MyData.txt"); // OK

IS = SomeClass.class.getResourceAsStream("SomePackage/MyData.txt"); // Not OK

IS = SomeClass.class.getResourceAsStream("MySubData.txt"); // Not OK

IS = SomeClass.class.getResourceAsStream("SomePackage/SomePackage2/MySubData.txt"); // OK

IS = SomeClass.class.getResourceAsStream("/SomePackage/SomePackage2/MySubData.txt"); // Not OK

IS = SomeClass.class.getResourceAsStream("/SomePackage2/MySubData.txt"); // Not OK

IS = SomeClass.class.getResourceAsStream("SomePackage2/MySubData.txt"); // OK