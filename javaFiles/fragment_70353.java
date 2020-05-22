Path path = new StringPath("<?php return $obj->getName(); ?>");
QuercusContext quercusContext = new QuercusContext();
ReadStream reader = path.openRead();
QuercusProgram program = QuercusParser.parse(quercusContext, null, reader);
WriteStream out = new WriteStream(StdoutStream.create());
QuercusPage page = new InterpretedPage(program);

Env env = new Env(quercusContext, page, out, null, null);

SomeObject someObj = new SomeObject();

JavaClassDef classDef = env.getJavaClassDefinition(someObject.getClass());
env.setGlobalValue("obj", new JavaValue(env, someObject, classDef));

Value value = NullValue.NULL;

try {
  value = program.execute(env);
}
catch (QuercusExitException e) {
}

out.flushBuffer();
out.free();

System.out.println(value);