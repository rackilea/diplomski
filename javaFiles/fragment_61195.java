STGroup group = new STGroup('$', '$');
group.registerRenderer(...);
CompiledST compiledTemplate = group.defineTemplate("name", ...);
compiledTemplate.hasFormalArgs = false; // very important!

// later on...
ST template = group.getInstanceOf("name");