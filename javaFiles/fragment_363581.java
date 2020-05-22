db.getMetadata().getSchema().getClasses().stream()
     .filter(oClass -> !oClass.getName().startsWith(ORIENTDB_CLASS_PREFIX)) //
     .forEach(oClass -> {
          try {
              oClass.truncate();
          } catch (IOException e) {
              LOGGER.warn("Not possible to truncate class " + oClass.getName(), e);
          }
     });