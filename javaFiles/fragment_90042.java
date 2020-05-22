package com.collection;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;


class PersonInfo implements Serializable{
    private String name;
    private int id;
    private double credit;
    public PersonInfo(){}
    public PersonInfo(String name,int id,int credit)
    {
        this.name=name;
        this.id=id;
        this.credit=credit;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public double getCredit() {
        return credit;
    }
    public void setCredit(double credit) {
        this.credit = credit;
    }

}
class ReadWrite
{
       public void writeFile(List<PersonInfo> information){

            try {
                FileOutputStream fos = new FileOutputStream("/home/mohammad.sadik/TestReadWrite.txt");
                ObjectOutputStream os = new ObjectOutputStream(fos);
                os.writeObject(information);
                os.flush();
                fos.close();
                os.close();

            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        public List<PersonInfo> readFile() {
            List<PersonInfo> dataFromFile=null;
            try {

                FileInputStream fis = new FileInputStream("/home/mohammad.sadik/TestReadWrite.txt");
                ObjectInputStream is = new ObjectInputStream(fis);
                dataFromFile=(List<PersonInfo>)is.readObject();
                fis.close();
                is.close();
                //return readFile();
            } catch (Exception e) {
                e.printStackTrace();
            }
            return dataFromFile;
            }
}
public class AboutPerson {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        List<PersonInfo> info = new ArrayList<PersonInfo>();
        List<PersonInfo> info2 = new ArrayList<PersonInfo>();
        ReadWrite rw=new ReadWrite();
        while (true) {
            System.out.println("\n");
            System.out.println("1. Input personal info\n"
                    + "2. Print them out\n"

                    + "*************"
                    + "*************");
           int option1 = input.nextInt();
            input.nextLine();
            switch (option1) {
                case 1:
                    PersonInfo personInfo = new PersonInfo();
                    //take the input
                    System.out.println("Enter a name: ");
                    personInfo.setName(input.nextLine());
                    System.out.println("Give ID: ");
                    personInfo.setId(input.nextInt());
                    System.out.println("Input credit: ");
                    personInfo.setCredit(input.nextDouble());
                    //addint them up
                    info.add(personInfo);
                    rw.writeFile(info);
                    break;
                case 2:
                    //display them 
                    info2=rw.readFile();
                    System.out.println("");
                    System.out.println("Name\t\tID\t\tCredit");
                    for (PersonInfo pinfo : info2) {
                        System.out.println(pinfo.getName()+"\t\t"+pinfo.getId()+"\t\t"+pinfo.getCredit());
                    }
                    System.out.println("\t\t.............\n"
                            + "\t\t.............");
                    break;

    }

        }
    }
}