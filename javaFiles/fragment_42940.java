List<ModuleInfo> modInfoList;

ModuleInfo moduleInfo = new ModuleInfo();
moduleInfo.setName(module, module1.getProperty("name"));
moduleInfo.setVersion(module, module1.getProperty("version"));
moduleInfo.setPublicCle(module, module1.getProperty("public_cle"));
moduleInfo.setType(module, module1.getProperty("type"));
modInfoList.add(moduleInfo);

moduleInfo = new ModuleInfo();
moduleInfo.setName(module, module2.getProperty("name"));
moduleInfo.setVersion(module, module2.getProperty("version"));
moduleInfo.setPublicCle(module, module2.getProperty("public_cle"));
moduleInfo.setType(module, module2.getProperty("type"));
modInfoList.add(moduleInfo);