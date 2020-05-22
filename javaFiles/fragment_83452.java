Class<?> type = new ByteBuddy()
     .makeInterface()
     .make()
     .load(getClass().getClassLoader(), ClassLoadingStrategy.Default.WRAPPER)
     .getLoaded();
assertThat(Modifier.isPublic(type.getModifiers()), is(true));
assertThat(type.isEnum(), is(false));
assertThat(type.isInterface(), is(true));
assertThat(type.isAnnotation(), is(false));