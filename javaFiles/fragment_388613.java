Map<String, Map<String, List<String>>> map = new HashMap<>();
        for(int i = 3;i<sheet.getRows();i++){
            if(!sheet.getCell(2,i).getContents().isEmpty()){
                lastUpdated = sheet.getCell(2,i).getContents();
            }

            if (!sheet.getCell(3,i).getContents().isEmpty()) {
                String content = sheet.getCell(3,i).getContents();
                if(!map.containsKey(lastUpdated)){
                    map.put(lastUpdated, new HashMap<>());
                }
                if(!map.get(lastUpdated).containsKey(content)){
                    Map<String, List<String>> rowMap = map.get(lastUpdated);
                    rowMap.put(content, new ArrayList<>());
                    map.put(lastUpdated, rowMap);
                }
                for(Cell c : Arrays.copyOfRange(sheet.getRow(i), 4, sheet.getRow(i).length)){
                    if(CellType.EMPTY != c.getType()){
                        map.get(lastUpdated).get(content).add(c.getContents());
                    }
                }
            }
        }