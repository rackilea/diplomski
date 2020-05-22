@Test
   public void componizePath_EmptyPath()
   {
      String[] actual = getSftp().componizePath("");
      String[] expected = new String[0];
      assertArrayEquals(expected, actual);
   }

   @Test
   public void componizePath_RootPath()
   {
      String[] actual = getSftp().componizePath("/");
      String[] expected = new String[] {"/"};
      assertArrayEquals(expected, actual);
   }

   @Test
   public void componizePath_SimplePath()
   {
      String[] actual = getSftp().componizePath("a");
      String[] expected = new String[] {"a"};
      assertArrayEquals(expected, actual);
   }

   @Test
   public void componizePath_SimplePathWithTrailingSlash()
   {
      String[] actual = getSftp().componizePath("a/");
      String[] expected = new String[] {"a/"};
      assertArrayEquals(expected, actual);
   }

   @Test
   public void componizePath_ComplexerPath()
   {
      String[] actual = getSftp().componizePath("a/b/cc");
      String[] expected = new String[] {"a/", "a/b/", "a/b/cc"};
      assertArrayEquals(expected, actual);
   }

   @Test
   public void componizePath_ComplexerPathWithTrailingSlash()
   {
      String[] actual = getSftp().componizePath("a/b/c/");
      String[] expected = new String[] {"a/", "a/b/", "a/b/c/"};
      assertArrayEquals(expected, actual);
   }

   @Test
   public void componizePath_ComplexerPathWithLeadingSlash()
   {
      String[] actual = getSftp().componizePath("/a/b/c");
      String[] expected = new String[] {"/", "/a/", "/a/b/", "/a/b/c"};
      assertArrayEquals(expected, actual);
   }