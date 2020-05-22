@Override
public String toString(){
    return String.format("%s %d, %s, %d %s"
        , getRoomName()
        , getRoomCode()
        , getRoomCapacity()
        , getNumOfLights()
        , getBuildingCode());
}