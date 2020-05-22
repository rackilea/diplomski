boolean added = false;
            while (priorityBlocking.peek() != null) {
                added = true;
                String symbol = priorityBlocking.poll();
                allSymbolsSet.add(symbol);
                try {
                    System.out.println("Symbol From priorityBlocking" +"  "+ symbol);
                }   catch (Exception e) {
                        e.printStackTrace();
                }
            }
            if (added) {
                Iterator<String> ite = allSymbolsSet.iterator();
                while (ite.hasNext()) {
                    String symbol = ite.next();
                    if (symbol != null && symbol.trim().length() > 0) {
                        try {
                            System.out.println("Symbol From allSymbolsSet"+"   "+symbol);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
            }