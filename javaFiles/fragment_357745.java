for (i = annots.size() - 1; i >= 0; --i) {
                Field field = new Field(annots.getAt((int) i));
                String nameField = field.getName();

                int range = nameField.indexOf("_FIXPDFBOX");
                int size = "_FIXPDFBOX".length();
                if (range != -1) {
                    int sub = range;
                    field.rename(nameField.substring(sub, sub+size));
                }
            }