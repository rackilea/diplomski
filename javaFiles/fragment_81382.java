int index = 0;
                while (index < string7.length) {
                    String string8 = string7[index];
                    if (string8.isEmpty()) { // assume there was a leading minus here
                        // reverse sign of next double
                        index++;
                        doubles.add(-Double.parseDouble(string7[index]));
                    } else {
                        doubles.add(Double.parseDouble(string8));
                    }
                    index++;
                }