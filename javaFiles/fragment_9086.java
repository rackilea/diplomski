@Override
  public boolean processActual(Set<? extends TypeElement> annotations, RoundEnvironment roundEnv) {
    if (roundEnv.processingOver()) {
      return false;
    }
    try {
      write(roundEnv);
    } catch (IOException e) {
      e.printStackTrace();
    }
    return false;
  }

  private void write(RoundEnvironment roundEnv) throws IOException, UnsupportedEncodingException {
    Filer filer = processingEnv.getFiler();
    FileObject resource = filer.createResource(StandardLocation.CLASS_OUTPUT, "", "TestInfo");
    OutputStream output = resource.openOutputStream();
    PrintStream writer = new PrintStream(output, false, "UTF-8");
    roundEnv.getElementsAnnotatedWith(Anno.class)
        .stream()
        .filter(e -> e.getKind() == ElementKind.CLASS)
        .map(e -> e.asType().toString())
        .forEach(writer::println);
    writer.flush();
  }