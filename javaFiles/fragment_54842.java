CellSetAxis columnAxis = (CellSetAxis) cellSet.getAxes().get(Axis.COLUMNS.axisOrdinal());
    CellSetAxis rowAxis = (CellSetAxis) cellSet.getAxes().get(Axis.ROWS.axisOrdinal());
    List<Position> colPositions = columnAxis.getPositions();
    List<Position> rowPositions = rowAxis.getPositions();

    for (Position axis_0 : colPositions) {
        List<Member> mem0 = axis_0.getMembers();
        for (Position axis_1 : rowPositions) {
            List<Member> mem1 = axis_1.getMembers();
            Cell currentCell = cellSet.getCell(axis_0, axis_1);
            data = new HashMap();
            for (int i = 0; i < mem0.size(); i++) {
                data.put(mem0.get(i).getDimension().getName().replaceAll(" ", ""), mem0.get(i).getUniqueName());
            }
            for (int i = 0; i < mem1.size(); i++) {
                data.put(mem1.get(i).getDimension().getName().replaceAll(" ", ""), mem1.get(i).getUniqueName());
            }
            data.put("value", Float.parseFloat((currentCell.getValue()==null)?"0":currentCell.getValue().toString()));
            data.put("cellID", count);
            data.put("Scenarios", scenario);
            collection.add(data);
            count+=1;
        }
    }