for (int i = 0; i < keys.length; i++) {
                if (!pair.getKey().equals(keys[i]) || pair.getValue() == null) {
                    return false; // mismatch found, doesn't need to verify 
                    // remaining pairs. 
                }

            }
return true; // all pairs satisfy the condition.