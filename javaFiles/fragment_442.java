for (int i = 0; i < aliases.length; i++) {
                    String alias = aliases[i];
                    if(alias != null) {
                        setters[i] = propertyAccessor.getSetter(resultClass, alias);
                    }
                }