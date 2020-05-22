public String LeggiCella(Sheet foglio, int col, int riga) {

        Cell a = foglio.getCell(col, riga);
        String contenuto = a.getContents();

        if (a.getType() == CellType.NUMBER){ 
            contenuto = Double.toString(LeggiCellaNumerica(a));
            } 

        return contenuto;
    }

    public double LeggiCellaNumerica(Cell a){
        double num = 0;

        NumberCell nc = (NumberCell) a; 
        num = nc.getValue();

        return num;
    }