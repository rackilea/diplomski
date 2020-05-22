WrongProtos.Foo.Builder outFoo = WrongProtos.Foo.newBuilder();
outFoo.setId(WrongProtos.SomeType.nativeFoo);
try (FileOutputStream output = new FileOutputStream("/tmp/proto.bin")) {
    outFoo.build().writeTo(output);
}
System.out.printf("outFoo number: %d  name: %s%n",
        outFoo.getId().getNumber(), outFoo.getId());

RightProtos.Foo inFoo = RightProtos.Foo.parseFrom(
        new FileInputStream("/tmp/proto.bin"));
System.out.printf("inFoo number: %d  name: %s%n",
        inFoo.getId().getNumber(), inFoo.getId());
}