ConvertCmd cmd = new ConvertCmd();
IMOperation op = new IMOperation();

op.addImage(sourcePath);
op.p_profile("*");
op.scale(123);
op.addImage(targetPath);

cmd.run(op);