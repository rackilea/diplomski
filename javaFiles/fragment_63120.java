String macrosSource = getMacros();
// Needed to create the fictional template, has no real purpose
Configuration wrapper = new Configuration(Configuration.VERSION_2_3_21);
wrapper.setObjectWrapper(new DefaultObjectWrapperBuilder(Configuration.VERSION_2_3_21).build());

// Fictional template which has the only purpose to hold your macroSource
Template macrosFictionalTemplate = new Template(null, macroSource, wrapper);

// Get template as you normally would
Template mainTemplate = configuration.getTemplate("main_template");

// Create a processing environment. This is an object on which you can call
// .process just as you can on a template. The model and out are the same as
// Template#process(model, out)
Environment mainTemplateEnvironment = mainTemplate.createProcessingEnvironment(model, out);

// Either include -> macros will be accessible as top-level
mainTemplateEnvironment.include(macrosFictionalTemplate);
// Or import -> macros will be accessible using macros.macroName
mainTemplateEnvironment.importLib(macrosFictionalTemplate, "macros");

// Process everything
mainTemplateEnvironment.process();