public class DataAccessFile{
    private  RandomAccessFile carsfile;

    Public DataAccessFile(RandomAccessFile carsFile){
        this.carsFile = carsFile;
     ....
    }
    public void writeData(Car car){
     ....
    }
    public Car readData(){
     .....
    }
}