package AsciiToDIVs;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Iterator;

public class CellGrid {

    private ArrayList<ArrayList<Cell>> CellGridData;

    public CellGrid(String asciiFile) throws IOException {
        readDataFile(asciiFile);
    }

    public ArrayList<FoundObject> findBoxes(FoundBoxObject parent)
    {

        int startRowIndex = 0, startColIndex = 0, 
                parentRowLimit = Integer.MAX_VALUE, 
                parentColLimit = Integer.MAX_VALUE,
                startingColIndex = 0;
        if(parent != null)
        {
            startRowIndex = parent.getRowIndex()+1;
            startColIndex = startingColIndex =  parent.getColIndex()+1;
            parentRowLimit = parent.getRowIndex() + parent.getHeight();
            parentColLimit = parent.getColIndex() + parent.getWidth();
        }

        ArrayList<FoundObject> results = new ArrayList<FoundObject>();

        Cell currentCell;

        if(startRowIndex>=CellGridData.size())
        return null;        

        for(; startRowIndex<CellGridData.size() && startRowIndex<parentRowLimit; startRowIndex++ )
        {
            startColIndex = startingColIndex;

            for(; startColIndex< CellGridData.get(startRowIndex).size() && startColIndex<parentColLimit; startColIndex++)
            {           
                FoundBoxObject withinBox = checkWithinFoundBoxObject(results, startRowIndex, startColIndex);

                if(withinBox !=null)
                startColIndex+=withinBox.getWidth();

                currentCell = getCell(startRowIndex, startColIndex);

                if(currentCell!=null)
                {
                    if(currentCell.Character == '-') // Found a TOP-CORNER
                    {
                        int boxHeight =  getConsecutiveIs(startRowIndex+1, startColIndex) + 1;
                        if(boxHeight>1)
                        {
                            int boxWidth = getConsecutiveDashes(startRowIndex, startColIndex);

                            FoundBoxObject box = new FoundBoxObject(startRowIndex, startColIndex, boxWidth, boxHeight, parent);
                            results.add(box);
                            findBoxes(box);

                            startColIndex+=boxWidth;                            
                        }                   
                    }

                    //This is a character
                    else if(currentCell.Character != '-' && currentCell.Character != 'I' && currentCell.Character != ' ' 
                            && currentCell.Character != '\n' && currentCell.Character != '\n' && currentCell.Character != '\t')
                    {
                        FoundCharObject Char = new FoundCharObject(startRowIndex, startColIndex, parent,  currentCell.Character);
                        results.add(Char);
                    }
                }
            }       
        }

        if(parent!=null)
        parent.containedObjects = results;

        return results;     
    }

    public static String printDIV(ArrayList<FoundObject> objects)
    {
        String result = "";
        Iterator<FoundObject> it = objects.iterator();
        FoundObject fo;

        while(it.hasNext())
        {
            result+="<div>";

            fo = it.next();

            if(fo instanceof FoundCharObject)
            {
                FoundCharObject fc = (FoundCharObject)fo;
                result+=fc.getChar();
            }

            if(fo instanceof FoundBoxObject)
            {
                FoundBoxObject fb = (FoundBoxObject)fo;
                result+=printDIV(fb.containedObjects);
            }

            result+="</div>";
        }

        return result;
    }

    private FoundBoxObject checkWithinFoundBoxObject(ArrayList<FoundObject> results, int rowIndex, int colIndex)
    {
        Iterator<FoundObject> it = results.iterator();
        FoundObject f;
        FoundBoxObject fbox = null;
        while(it.hasNext())
        {
            f = it.next();

            if(f instanceof FoundBoxObject)
            {
                fbox = (FoundBoxObject) f;

                if(rowIndex >= fbox.getRowIndex() && rowIndex <= fbox.getRowIndex() + fbox.getHeight())
                {
                    if(colIndex >= fbox.getColIndex() && colIndex <= fbox.getColIndex() + fbox.getWidth())
                    {
                        return fbox;
                    }
                }
            }
        }

        return null;
    }

    private int getConsecutiveDashes(int startRowIndex, int startColIndex)
    {
        int counter = 0;
        Cell cell = getCell(startRowIndex, startColIndex);

        while( cell!=null && cell.Character =='-')
        {
            counter++;
            cell = getCell(startRowIndex, startColIndex++);
        }

        return counter;

    }

    private int getConsecutiveIs(int startRowIndex, int startColIndex)
    {
        int counter = 0;
        Cell cell = getCell(startRowIndex, startColIndex);

        while( cell!=null && cell.Character =='I')
        {
            counter++;
            cell = getCell(startRowIndex++, startColIndex);
        }

        return counter;
    }

    public Cell getCell(int rowIndex, int columnIndex)
    {
        ArrayList<Cell> row;


        if(rowIndex<CellGridData.size())
        row = CellGridData.get(rowIndex);
        else return null;

        Cell cell = null;

        if(row!=null){
            if(columnIndex<row.size())
            cell = row.get(columnIndex);
        }

        return cell;
    }


    public Iterator<ArrayList<Cell>> getRowGridIterator(int StartRow) {
        Iterator<ArrayList<Cell>> itRow = CellGridData.iterator();

        int CurrentRow = 0;

        while (itRow.hasNext()) {
            // Itrate to Row
            if (CurrentRow++ < StartRow)
                itRow.next();

        }
        return itRow;
    }

    private void readDataFile(String asciiFile) throws IOException {
        CellGridData = new ArrayList<ArrayList<Cell>>();
        ArrayList<Cell> row;

        FileInputStream fstream = new FileInputStream(asciiFile);
        BufferedReader br = new BufferedReader(new InputStreamReader(fstream));

        String strLine;

        // Read File Line By Line
        int rowIndex = 0;
        while ((strLine = br.readLine()) != null) {
            CellGridData.add(row = new ArrayList<Cell>());
            // System.out.println (strLine);
            for (int colIndex = 0; colIndex < strLine.length(); colIndex++) {
                row.add(new Cell(strLine.charAt(colIndex), this, rowIndex,colIndex));
                // System.out.print(strLine.charAt(i));
            }
            rowIndex++;
            // System.out.println();
        }

        // Close the input stream
        br.close();
    }

    public String printGrid() {
        String result = "";

        Iterator<ArrayList<Cell>> itRow = CellGridData.iterator();
        Iterator<Cell> itCol;
        Cell cell;

        while (itRow.hasNext()) {
            itCol = itRow.next().iterator();

            while (itCol.hasNext()) {
                cell = itCol.next();
                result += cell.Character;
            }
            result += "\n";
        }

        return result;
    }

}