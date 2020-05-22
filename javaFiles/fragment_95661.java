import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Stack;

public class FieldGenerator {

private int _width;
private int _height;
private Cell[][] _field;

public FieldGenerator(int width, int height){
    _width = width;
    _height = height;
    _field = new Cell[height][width];

}

public Cell[][] getField(){
    Random rand = new Random(System.currentTimeMillis());
    int total = _width * _height;
    for(int y = 0; y < _height; y++){
        for(int x = 0; x < _width; x++){
            _field[y][x] = new Cell(cellstate.UNWALKABLE, x, y);
        }
    }
    int xStart = rand.nextInt(_width);
    int yStart = rand.nextInt(_height);
    Cell currentCell = _field[yStart][xStart];
    currentCell.setCellstate(cellstate.STARTINGPOINT);
    Stack<Cell> stack = new Stack<Cell>();
    int visited = 1;
    while (visited < total){
        List<Cell> neighbourList = getNeighbours(currentCell);
        if(neighbourList.size() > 0){ //1 or more neighbours with walls intact
            Cell randNeighbour = neighbourList.get(rand.nextInt(neighbourList.size()));
            clearWallBetween(currentCell, randNeighbour);
            stack.push(currentCell);
            currentCell = randNeighbour;
            visited++;
            if(visited >= total)
                placeEndPoint(findCellByState(cellstate.STARTINGPOINT));
        }else{
            if(!stack.isEmpty()) {
                currentCell = stack.pop();
            }else {
                placeEndPoint(findCellByState(cellstate.STARTINGPOINT));
                return _field;
            }
        }
    }
    return _field;
}

private List<Cell> getNeighbours(Cell searchCell){
    List<Cell> retList = new ArrayList<Cell>();
    int x = searchCell.getx();
    int y = searchCell.gety();

    if(findCellByCoordinates(x, y-2) != null && findCellByCoordinates(x, y-2).getCellstate() == cellstate.UNWALKABLE){ //Top
        retList.add(findCellByCoordinates(x, y-2));
    }
    if(findCellByCoordinates(x-2, y) != null && findCellByCoordinates(x-2, y).getCellstate() == cellstate.UNWALKABLE) { //Left
        retList.add(findCellByCoordinates(x-2, y));
    }
    if(findCellByCoordinates(x+2, y) != null && findCellByCoordinates(x+2, y).getCellstate() == cellstate.UNWALKABLE) { //Right
        retList.add(findCellByCoordinates(x+2, y));
    }
    if(findCellByCoordinates(x, y+2) != null && findCellByCoordinates(x, y+2).getCellstate() == cellstate.UNWALKABLE) { //Bottom
        retList.add(findCellByCoordinates(x, y+2));
    }

    return retList;
}

private void placeEndPoint(Cell startcell){
    Random rand = new Random(System.currentTimeMillis());
    int startx = startcell.getx();
    int starty = startcell.gety();
    int geny = 0;
    int genx = 0;
    do{
        genx = rand.nextInt(_width);
        geny = rand.nextInt(_height);
    }while((startx == genx && geny == starty) || _field[geny][genx].getCellstate() == cellstate.UNWALKABLE);
    _field[geny][genx].setCellstate(cellstate.ENDINGPOINT);
}

private Cell findCellByCoordinates(int xcoord, int ycoord){
    if(xcoord >= _width || xcoord < 0 || ycoord >= _height || ycoord < 0) {
        return null;
    }else{
        return _field[ycoord][xcoord];
    }
}

private Cell findCellByState(cellstate searchstate){
    for (int y = 0; y < _height; y++){
        for (int x = 0; x < _width; x++) {
            if(_field[y][x].getCellstate() == searchstate){
                return _field[y][x];
            }
        }
    }
    return null;
}

private void clearWallBetween(Cell cell1, Cell cell2){
    if(cell2.getCellstate() != cellstate.STARTINGPOINT || cell2.getCellstate() != cellstate.ENDINGPOINT)
        cell2.setCellstate(cellstate.WALKABLE);
    int x = ((cell1.getx() + cell2.getx()) / 2);
    int y = ((cell1.gety() + cell2.gety()) / 2);
    _field[y][x].setCellstate(cellstate.WALKABLE);
}

}