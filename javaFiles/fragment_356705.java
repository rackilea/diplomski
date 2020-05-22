public class PivotUtilitiesExample {
    public static void updateCache(XSSFPivotTable pivotTable) {
        updateCache(pivotTable,STAxis.AXIS_ROW);
        updateCache(pivotTable,STAxis.AXIS_COL);
        updateCache(pivotTable,STAxis.AXIS_PAGE);
    }
    /**
     * Updates the pivotCacheDefinition.xml file.  This must be run before any formatting is done.
     * However, it must also be run *AFTER* the pivotTable's source data is created and all label definitions are defined.
     *   the labels are sorted by default.
     * @param pivotTable
     * @param rowLabel if true, updates rowLabels, if false, updates columnLabels.
     */
    private static void updateCache(XSSFPivotTable pivotTable,STAxis.Enum axisType) {
        XSSFSheet sheet=(XSSFSheet) pivotTable.getDataSheet();
        AreaReference pivotArea = new AreaReference(pivotTable.getPivotCacheDefinition().
                getCTPivotCacheDefinition().getCacheSource().getWorksheetSource().getRef());
        CellReference firstCell = pivotArea.getFirstCell();
        CellReference lastCell = pivotArea.getLastCell();
        List<Integer> labelColumns=getLabelColumns(pivotTable,axisType);

        for(int labelCtr=0;labelCtr<labelColumns.size();++labelCtr) {
            CTSharedItems sharedItems=getSharedItems(pivotTable,labelColumns.get(labelCtr));
            //The pivotField entry associated will be the nth axis="axisRow" entry where N is the row label #.
            CTPivotField pivotField=getPivotField(pivotTable,axisType,labelCtr);
            CTItems items=pivotField.getItems();

            ArrayList<String> toCache=new ArrayList<String>(lastCell.getRow()-firstCell.getRow());
            //To make this work, sharedItems and pivotFields must be properly populated.
            //sharedItems should look like:
            //<cacheField name="Names" numFmtId="0"> (Cell A1)
            //<sharedItems count="3">                (Count of unique rows)
            //<s v="Jane"/>                          (Cell B1)
            //<s v="Tarzan"/>                        (Cell C1)
            //<s v="Terk"/>                          (Cell D1)
            //</sharedItems>
            //pivotFields should have an entry like this:
            //<pivotField axis="axisRow" showAll="0">
            //<items count="4">
            //<item x="0"/>
            //<item x="1"/>
            //<item x="2"/>
            //<item t="default"/>
            //</items>
            //Initially, POI will populate with:
            //<pivotField axis="axisRow" showAll="0">
            //<items count="4">
            //<item t="default"/>
            //<item t="default"/>
            //<item t="default"/>
            //<item t="default"/>
            //</items>
            //Start with firstCell.getRow()+1 since the first row is the column name.
            for(int i=firstCell.getRow()+1;i<=lastCell.getRow();++i) {
                String s=sheet.getRow(i).getCell(firstCell.getCol()+labelColumns.get(labelCtr)).getStringCellValue();
                //Only add unique entries.
                if(!toCache.contains(s))
                    toCache.add(s);
            }
            //Blank entries cannot be sorted unless they are specially entered after an M tag.
            //  For most projects this'll be overkill.
            boolean containsBlank=false;
            if(toCache.contains("")) {
                toCache.remove("");
                containsBlank=true;
            }
            //Remove the old cache list.
            for(int i=items.sizeOfItemArray()-1;i>=0;--i)
                items.removeItem(i);
            for(int i=sharedItems.sizeOfBArray()-1;i>=0;--i)
                sharedItems.removeB(i);
            for(int i=sharedItems.sizeOfDArray()-1;i>=0;--i)
                sharedItems.removeD(i);
            for(int i=sharedItems.sizeOfEArray()-1;i>=0;--i)
                sharedItems.removeE(i);
            for(int i=sharedItems.sizeOfMArray()-1;i>=0;--i)
                sharedItems.removeM(i);
            for(int i=sharedItems.sizeOfNArray()-1;i>=0;--i)
                sharedItems.removeN(i);
            for(int i=sharedItems.sizeOfSArray()-1;i>=0;--i)
                sharedItems.removeS(i);
            sharedItems.setCount(sharedItems.getDomNode().getChildNodes().getLength());
            items.setCount(items.sizeOfItemArray());
            for(int i=0;i<toCache.size();++i) {
                CTString string;
                CTItem item;
                string=sharedItems.addNewS();
                sharedItems.setCount(sharedItems.getDomNode().getChildNodes().getLength());
                string.setV(toCache.get(i));

                item=items.addNewItem();
                items.setCount(items.sizeOfItemArray());
                item.setX(i);
            }
            //Create the special blank tag.
            if(containsBlank) {
                int mPosition;
                sharedItems.addNewM();
                mPosition=sharedItems.sizeOfSArray();
                CTString s=sharedItems.addNewS();
                s.setV("");
                s.setU(true);
                sharedItems.setCount(sharedItems.getDomNode().getChildNodes().getLength());
                sharedItems.setContainsBlank(true);
                CTItem item=items.addNewItem();
                item.setM(true);
                item.setX(sharedItems.sizeOfSArray());
                item=items.addNewItem();
                item.setX(mPosition);
                items.setCount(items.sizeOfItemArray());
            }
            //Add the t="default" entry, required for subtotals.
            if(!pivotField.isSetDefaultSubtotal() || pivotField.getDefaultSubtotal()==true) {
                CTItem item;
                item=items.addNewItem();
                items.setCount(items.sizeOfItemArray());
                item.setT(STItemType.DEFAULT);
            }
        }
    }
    //Returns the label columns for all AXIS.  Default POI only has a method for RowLabelColumns.
    private static List<Integer> getLabelColumns(XSSFPivotTable pivotTable,STAxis.Enum axisType) {
        List<Integer> labelColumns;
        if(axisType.equals(STAxis.AXIS_ROW))
            labelColumns=pivotTable.getRowLabelColumns();
        else if(axisType.equals(STAxis.AXIS_COL)) {
            List<CTField> fieldList = pivotTable.getCTPivotTableDefinition().getColFields().getFieldList();
            labelColumns=new ArrayList(fieldList.size());
            for(CTField field:fieldList)
                labelColumns.add(field.getX());
        } else if(axisType.equals(STAxis.AXIS_PAGE)) {
            List<CTPageField> fieldList = pivotTable.getCTPivotTableDefinition().getPageFields().getPageFieldList();
            labelColumns=new ArrayList(fieldList.size());
            for(CTPageField field:fieldList)
                labelColumns.add(field.getFld());
        } else {
            throw new UnsupportedOperationException("Error, STAxis: "+axisType+" is not supported");
        }
        return labelColumns;
    }
    //Returns the sharedItems entry associated with a particular labelColumn.
    private static CTSharedItems getSharedItems(XSSFPivotTable pivotTable,int columnIndex) {
        XSSFSheet sheet=(XSSFSheet) pivotTable.getDataSheet();
        AreaReference pivotArea = new AreaReference(pivotTable.getPivotCacheDefinition().
                getCTPivotCacheDefinition().getCacheSource().getWorksheetSource().getRef());
        CellReference firstCell = pivotArea.getFirstCell();
        String labelName=sheet.getRow(firstCell.getRow()).getCell(firstCell.getCol()+columnIndex).getStringCellValue();
        List<CTCacheField> cacheFieldList = pivotTable.getPivotCacheDefinition().getCTPivotCacheDefinition().getCacheFields().getCacheFieldList();
        CTSharedItems sharedItems=null;
        //The sharedItem entry associated will have name=labelColumn's name.
        for(int i=0;i<cacheFieldList.size();++i)
            if(labelName.equals(cacheFieldList.get(i).getName())) {
                sharedItems=cacheFieldList.get(i).getSharedItems();
                break;
            }
        //Should never be true.
        if(sharedItems==null) {
            throw new RuntimeException("Error, unable to find sharedItems entry in pivotCacheDefinition.xml");
        }
        return sharedItems;
    }
    //Return the nth pivotField entry from the pivotTable definition of a particular Axis.
    private static CTPivotField getPivotField(XSSFPivotTable pivotTable,STAxis.Enum axisType,int index) {
        CTPivotFields pivotFields = pivotTable.getCTPivotTableDefinition().getPivotFields();
        CTPivotField pivotField=null;
        for(int i=0,axisRowNum=-1;i<pivotFields.getPivotFieldList().size();++i) {
            if(axisType.equals(pivotFields.getPivotFieldList().get(i).getAxis()))
                ++axisRowNum;
            if(axisRowNum==index) {
                pivotField=pivotFields.getPivotFieldList().get(i);
                break;
            }
        }
        if(pivotField==null)
            throw new RuntimeException("Error, unable to find pivotField entry in pivotTable.xml");
        return pivotField;
    }
}