package testingforan;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class NewInnerMap {

public static final int MAX_ROWS = 20;
public static final int MIN_ROWS = 19;
public static final int MAX_COLS = 21;
public static final int MIN_COLS = 18;

public static final int MAX_LENGTH = 30;


private String [][] im;
private int numRow;
private int numCol;

private Tuple startingPosition;

public NewInnerMap(){
    this.init();
}




    private void init(){

        this.numRow = randomBetween(NewInnerMap.MIN_ROWS, NewInnerMap.MAX_ROWS);
        this.numCol = randomBetween(NewInnerMap.MIN_COLS, NewInnerMap.MAX_COLS);
        this.im = new String[numRow][numCol];

        this.startingPosition = this.getRandomStartingPosition();

        this.generateMap();
    }//end init


    private void generateMap(){
         this.setStringToMap("Start", startingPosition);
         this.nextPath(startingPosition, -1, 0);
    }

    private int [] getHeuristics(Tuple pos, int lastDirection){

        //top, right, bottom, left
         int [] heuristic = new int[] {0,0,0,0};

         Tuple top = new Tuple(pos.getRow() - 1, pos.getCol());
         Tuple right = new Tuple(pos.getRow(), pos.getCol()+ 1);
         Tuple bottom = new Tuple(pos.getRow() + 1, pos.getCol());
         Tuple left = new Tuple(pos.getRow(), pos.getCol() - 1);


         //top
         if(pos.getRow() - 1 >= 0){
         heuristic[0] += this.getHeuristicForPositionBasedOnNumSurroundings(top);
         //heuristic for going straight is given a random chance
         if(lastDirection == 0){
             heuristic[0] += randomBetween(0,3);
         }//end if
         }


         if(pos.getCol()+1 < im[0].length){
         //right
         heuristic[1] += this.getHeuristicForPositionBasedOnNumSurroundings(right);
         if(lastDirection == 1){
             heuristic[1] += randomBetween(0,3);
         }
         }


         if(pos.getRow()+1 < im.length){
         //bottom
         heuristic[2] += this.getHeuristicForPositionBasedOnNumSurroundings(bottom);
         //heuristic for going straight is given a random chance
         if(lastDirection == 2){
             heuristic[2] += randomBetween(0,3);
         }//end if
         }


         if(pos.getCol() - 1 >= 0){
         //left
         heuristic[3] += this.getHeuristicForPositionBasedOnNumSurroundings(left);
         //heuristic for going straight is given a random chance
         if(lastDirection == 3){
             heuristic[3] += randomBetween(0,3);
         }//end if

         }
         return heuristic;
    }//emnd getHeuristics



    /*
        exists piece -> -1
        no empty surrounding -> -1
        1 empty surrounding -> -1
        2 empty surrounding -> -1
        3 empty surrounding -> 10
    */
    private int getHeuristicForPositionBasedOnNumSurroundings(Tuple pos){
        if(this.im[pos.getRow()][pos.getCol()] != null ||
                this.numEmptySurrounding(pos) == 1 ||
                this.numEmptySurrounding(pos) == 2 ){
            return -100;
        } else {

            return 15;
            //return this.numEmptySurrounding(pos);
        }
    }//end getHeuristicForPositionBasedOnNumSurroundings


    /*
            startPath -> find next possible moves
            next possible moves -> store in array, give them a weight

            should not border other than previous = max weight
            going straight = weighted

            if -> this path is 3 empty, possibly branch
    */
    public void nextPath(Tuple lastPos, int dir, int depth){

        int [] fh = this.getHeuristics(lastPos, dir);
        int max = maxFromIntArray(fh);

        if(fh[max] <= 5 || depth >= NewInnerMap.MAX_LENGTH){
            im[lastPos.getRow()][lastPos.getCol()] = "Finish";
        }//end if

        else if(im[lastPos.getRow()][lastPos.getCol()] != null){
            if(im[lastPos.getRow()][lastPos.getCol()].equals("Start")){
            this.nextPath(this.getNextPositionBasedOnDirection(lastPos, max), max, depth+1);
            }
        }//end else if

        else{
            im[lastPos.getRow()][lastPos.getCol()] = Integer.toString(depth);
            this.nextPath(this.getNextPositionBasedOnDirection(lastPos, max), max, depth+1);
        }//end else

    }//end



    /*

            HEURISTIC BUILDERS ------------------

    */

    private boolean [] nextEmpty(Tuple pos){
        boolean [] availableNext = new boolean[]{false, false, false, false};

        //up
        if(isEmpty(new Tuple(pos.getRow() - 1, pos.getCol()))){
            availableNext[0] = true;
        }

        //right
        if(isEmpty(new Tuple(pos.getRow(), pos.getCol() + 1))){
             availableNext[1] = true;
        }

        //down
        if(isEmpty(new Tuple(pos.getRow() + 1, pos.getCol()))){
             availableNext[2] = true;
        }

        //left
        if(isEmpty(new Tuple(pos.getRow(), pos.getCol() - 1))){
              availableNext[3] = true;
        }

        return availableNext;
    }//end numSurrounding

    private int numEmptySurrounding(Tuple pos){
        boolean [] avaN = this.nextEmpty(pos);
        int emptySurrounding = 0;

   /*    if(pos.getRow() == 0 
               || pos.getRow() == im.length - 1
               ){
            emptySurrounding ++;
        } 

        if(pos.getCol() == 0 
                || pos.getCol() == im[0].length - 1
                ){
            emptySurrounding++;
        }
        */

        for(int i=0; i<avaN.length; i++){
            if(avaN[i] == true) { emptySurrounding++; }
        }//end for
        return emptySurrounding;
    }//end numEmptySurrounding


    private boolean isEmpty(Tuple testPos){
        if(testPos.getRow() >= 0 && testPos.getCol() >= 0 && testPos.getRow() < this.im.length && testPos.getCol() < this.im[0].length) {
            if (this.im[testPos.getRow()][testPos.getCol()] == null) {
                return true;
            }
        }//end if
        return false;
    }//end isEmpty

    private Tuple getNextPositionBasedOnDirection(Tuple pos, int dir){

        if(dir == 0){
            return new Tuple(pos.getRow() - 1, pos.getCol());
        }

        else if(dir == 1){
            return new Tuple(pos.getRow(), pos.getCol() + 1);
        }

        else if(dir == 2){
            return new Tuple(pos.getRow() + 1, pos.getCol());
        }

        else if (dir == 3){
            return new Tuple(pos.getRow(), pos.getCol() -1);
        }

        return new Tuple(-1,-1);
    }


    /*

        UTILITY CLASSES ----------------------------

    */

    private void setStringToMap(String s, Tuple pos){
        this.im[pos.getRow()][pos.getCol()] = s;
    }

    private void setIntToMap(int i, Tuple pos){
        this.setStringToMap(Integer.toString(i), pos);
    }

    private static int randomBetween(int min, int max){
        Random r = new Random();
        return r.nextInt((max-min)+1) + min;
    }//end randomBetween

    private Tuple getRandomStartingPosition(){
        return new Tuple(randomBetween(0,im.length-1), randomBetween(0,im[0].length-1));
    }//end getRandomStartingPosition

    private Tuple getRandomStartingPosition(Tuple min, Tuple max){
        return new Tuple(randomBetween(min.getRow(),max.getRow()), randomBetween(min.getCol(), max.getCol()));
    }//end getRandomStartingPosition

    private static int maxFromIntArray(int [] arr){
        List <Integer> numMax = new ArrayList<>();
        int max = 0;
        numMax.add(max);
        for(int i=1; i<arr.length; i++){
            if(arr[i] > arr[max]){
                numMax.removeAll(numMax);
                max = i;
                numMax.add(i);
            } else if(arr[i] == arr[max]){
                numMax.add(i);
            }
        }
        return numMax.get(randomBetween(0,numMax.size()-1));
    }//end maxFromIntArray

    public String [][] getIm(){
        return this.im;
    }

}//end class