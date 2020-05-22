if (anObject != null && !isEditable()) {
            // For non editable combo boxes, an invalid selection
            // will be rejected.
            boolean found = false;
            for (int i = 0; i < dataModel.getSize(); i++) {
                E element = dataModel.getElementAt(i);
                if (anObject.equals(element)) {
                    found = true;
                    objectToSelect = element;
                    break;
                }
            }
            if (!found) {
                return;
            }
        }