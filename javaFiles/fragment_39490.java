/**
   * convert object to json
   */
  public String toJson(Object obj) {
    // Convert emtpy string and objects to null so we don't serialze them
    setEmtpyStringsAndObjectsToNull(obj);
    return gson.toJson(obj);
  }

  /**
   * Sets all empty strings and objects (all fields null) including sets to null.
   *
   * @param obj any object
   */
  public void setEmtpyStringsAndObjectsToNull(Object obj) {
    for (Field field : obj.getClass().getDeclaredFields()) {
      field.setAccessible(true);
      try {
        Object fieldObj = field.get(obj);
        if (fieldObj != null) {
          Class fieldType = field.getType();
          if (fieldType.isAssignableFrom(String.class)) {
            if(fieldObj.equals("")) {
              field.set(obj, null);
            }
          } else if (fieldType.isAssignableFrom(Set.class)) {
            for (Object item : (Set) fieldObj) {
              setEmtpyStringsAndObjectsToNull(item);
            }
            boolean setFielToNull = true;
            for (Object item : (Set) field.get(obj)) {
              if(item != null) {
                setFielToNull = false;
                break;
              }
            }
            if(setFielToNull) {
              setFieldToNull(obj, field);
            }
          } else if (!isPrimitiveOrWrapper(fieldType)) {
            setEmtpyStringsAndObjectsToNull(fieldObj);
            boolean setFielToNull = true;
            for (Field f : fieldObj.getClass().getDeclaredFields()) {
              f.setAccessible(true);
              if(f.get(fieldObj) != null) {
                setFielToNull = false;
                break;
              }
            }
            if(setFielToNull) {
              setFieldToNull(obj, field);
            }
          }
        }
      } catch (IllegalAccessException e) {
        System.err.println("Error while setting empty string or object to null: " + e.getMessage());
      }
    }
  }

  private void setFieldToNull(Object obj, Field field) throws IllegalAccessException {
    if(!Modifier.isFinal(field.getModifiers())) {
      field.set(obj, null);
    }
  }

  private boolean isPrimitiveOrWrapper(Class fieldType)  {
    return fieldType.isPrimitive()
        || fieldType.isAssignableFrom(Integer.class)
        || fieldType.isAssignableFrom(Boolean.class)
        || fieldType.isAssignableFrom(Byte.class)
        || fieldType.isAssignableFrom(Character.class)
        || fieldType.isAssignableFrom(Float.class)
        || fieldType.isAssignableFrom(Long.class)
        || fieldType.isAssignableFrom(Double.class)
        || fieldType.isAssignableFrom(Short.class);
  }