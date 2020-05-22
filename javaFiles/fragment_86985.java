package paranoid;

import java.awt.Color;
import java.awt.Graphics;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

public class TripModel {
private List<TripModelListener> listeners = new CopyOnWriteArrayList<TripModelListener>();
private int xmin = 0,
            xmax = 499,
            ymin = 0,
            ymax = 279;
private int x = 120;
private int y = 80;
private int dx = 1;
private int dy = 1;
private int temp = 0;
private int update_counter = 0;
private int x_pos[] = new int[6];
private int y_pos[] = new int[6];
private int screen[][] = new int[500][280];


public TripModel() {

    initialisation();
}

public void initialisation(){
    System.out.println("initialising...");
    x_pos[0] = x;
    y_pos[0] = y;

    x_pos[1] = xmax - x;
    y_pos[1] = y;

    x_pos[2] = x;
    y_pos[2] = ymax - y;

    x_pos[3] = xmax - x;
    y_pos[3] = ymax - y;

    x_pos[4] = (int)(xmax/2)-50;
    y_pos[4] = (int)(ymax/2);

    x_pos[5] = (int)(xmax/2)+50;
    y_pos[5] = (int)(ymax/2);

    for(int j = 0; j<280; j++){
        for(int i = 0; i<500; i++){
            screen[i][j] = 0;
        }
    }
} //end of initialisation()

public void update(){
    //System.out.println("updating... for the "+update_counter+"th time");

    temp = (int)Math.floor(Math.random()*100);
    if(temp < 40){ // 40% chance that the direction is changed
        dx = (int)Math.floor(Math.random()*3);
        dy = (int)Math.floor(Math.random()*3);
        dx = dx - 1;
        dy = dy - 1;
    }


    x_pos[0] = x_pos[0]+dx;
    y_pos[0] = y_pos[0]+dy;

    x_pos[1] = x_pos[1]-dx;
    y_pos[1] = y_pos[1]+dy;

    x_pos[2] = x_pos[2]+dx;
    y_pos[2] = y_pos[2]-dy;

    x_pos[3] = x_pos[3]-dx;
    y_pos[3] = y_pos[3]-dy;

    x_pos[4] = x_pos[4]-dy;
    y_pos[4] = y_pos[4]-dx;

    x_pos[5] = x_pos[5]+dy;
    y_pos[5] = y_pos[5]+dx;

    for(int k = 0; k < 6; k++){
        if(x_pos[k] < 0){
            x_pos[k] = 0;
        }
        if(x_pos[k] > 499){
            x_pos[k] = 499;
        }
    }

    for(int k = 0; k < 6; k++){
        if(y_pos[k] < 0){
            y_pos[k] = 0;
        }
        if(y_pos[k] > 279){
            y_pos[k] = 279;
        }
    }


    screen[x_pos[0]][y_pos[0]] = 1;
    screen[x_pos[1]][y_pos[1]] = 1;
    screen[x_pos[2]][y_pos[2]] = 1;
    screen[x_pos[3]][y_pos[3]] = 1;
    screen[x_pos[4]][y_pos[4]] = 1;
    screen[x_pos[5]][y_pos[5]] = 1;

    update_counter = update_counter + 1;
    fireModelChangedListener();
} //end of update()

private void fireModelChangedListener() {
    for (TripModelListener listener : listeners) {
        listener.modelChanged();
    }
}


public int getXMin() {
    return xmin;
}

public int getYMin() {
    return ymin;
}

public int getYmin() {
    return ymin;
}

public void setYmin(int ymin) {
    this.ymin = ymin;
}

public int getXMax() {
    return xmax;
}

public int getXmax() {
    return xmax;
}

public void setXmax(int xmax) {
    this.xmax = xmax;
}

public int getYMax() {
    return ymax;
}

public int[][] getScreen() {
    return screen;
}

public void addListener( TripModelListener listener) {
    listeners.add(listener);
}
}