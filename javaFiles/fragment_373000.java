import java.util.*;
public class Collections1 {

public static void main(String[] args) {
    // TODO Auto-generated method stub
    ArrayList<String> FName=new ArrayList<>();
    FName.add("A");
    FName.add("B ");
    FName.add("C ");
    FName.add("D ");
    ArrayList<String> SName=new ArrayList<>();
    SName.add("E");
    SName.add("F");
    SName.add("G");
    SName.add("H");

    ArrayList<String> FullName=new ArrayList<>();

    if(FName.size()==SName.size()){
        for(int i=0;i<FName.size();i++){
            FullName.add(FName.get(i).trim()+SName.get(i).trim());
        }
    }

    for(int j=0;j<FullName.size();j++){
        System.out.println(FullName.get(j));
    }

   }

  }