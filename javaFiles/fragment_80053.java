@Bean
      public ViewResolver xsltViewResolver() {
          XsltViewResolver viewResolver = new XsltViewResolver();
          viewResolver.setPrefix("classpath:/templates/");
          viewResolver.setSuffix(".xslt");
          return viewResolver;
      }