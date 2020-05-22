.filter(e -> {
                String[] value = e.getValue();
                if (value == null || value.length == 0) {
                    return false;
                } else {
                    for (String element : value) {
                        if (element != null && !element.isEmpty()) {
                            return true;
                        }
                    }
                    return false;
                }
            })