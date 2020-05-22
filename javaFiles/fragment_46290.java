/**
 * Made by Aaron Cohen
 */

//http://introcs.cs.princeton.edu/java/assignments/mozart.html
import java.util.Random;
import java.util.Scanner;
import java.io.File;
import java.nio.file.*;
import java.lang.StringBuilder;

public class Main
{
    public static String name;
    public static String originalname;
    public static void main (String[] args){
        Scanner scanny = new Scanner(System.in);
        System.out.print("Want to hear your own personal waltz in the style of Mozart?\n");
        System.out.print("This is your own waltz bounded to your name. It is different from\n");
        System.out.print("anybody else's waltz. There are 1.3*10^29 different possible\n");
        System.out.println("possibilities and this is yours. Enter your name to proceed:\n");
        name = scanny.nextLine();
        originalname = name;
        name = name.toLowerCase();
        System.out.println("\nHold on just a second while your piece is being generated...");
        String reversedname = new StringBuilder(name).reverse().toString();
        while(name.length() < 32){
            name += reversedname;
            name += originalname;
        }
        char[] letters = name.toCharArray();
        int[] numbers = new int[32];
        for(int i = 0; i < 32; i++){
            numbers[i] = (int) letters[i] - 96;
        }
        /*
        for(int i : numbers){
        System.out.println(i);
        }
         */
        int[][] minuet = new int[][]{
                { 96, 22, 141, 41, 105, 122, 11, 30, 70, 121, 26, 9, 112, 49, 109, 14 },
                { 32, 6, 128, 63, 146, 46, 134, 81, 117, 39, 126, 56, 174, 18, 116, 83},
                { 69, 95, 158, 13, 153, 55, 110, 24, 66, 139, 15, 132, 73, 58, 145, 79},
                { 40, 17, 113, 85, 161,  2, 159, 100, 90, 176,  7, 34, 67, 160, 52, 170},
                { 148, 74, 163, 45, 80, 97, 36, 107, 25, 143, 64, 125, 76, 136, 1, 93},
                { 104, 157, 27, 167, 154, 68, 118, 91, 138, 71, 150, 29, 101, 162, 23, 151},
                { 152, 60, 171, 53, 99, 133, 21, 127, 16, 155, 57, 175, 43, 168, 89, 172}, 
                { 119, 84, 114, 50, 140, 86, 169, 94, 120, 88, 48, 166, 51, 115, 72, 111},
                { 98, 142, 42, 156, 75, 129, 62, 123, 65, 77, 19, 82, 137, 38, 149, 8},
                { 3, 87, 165, 61, 135, 47, 147, 33, 102, 4, 31, 164, 144, 59, 173, 78},
                { 54, 130, 10, 103, 28, 37, 106,  5, 35, 20, 108, 92, 12, 124, 44, 131},
            };

        int[] chosenminuet = new int[16];

        int[][] trio = new int[][]{
                { 72, 6, 59, 25, 81, 41, 89, 13, 36, 5, 46, 79, 30, 95, 19, 66},
                { 56, 82, 42, 74, 14, 7, 26, 71, 76, 20, 64, 84, 8, 35, 47, 88},
                { 75, 39, 54, 1, 65, 43, 15, 80, 9, 34, 93, 48, 69, 58, 90, 21},
                { 40, 73, 16, 68, 29, 55, 2, 61, 22, 67, 49, 77, 57, 87, 33, 10},
                { 83, 3, 28, 53, 37, 17, 44, 70, 63, 85, 32, 96, 12, 23, 50, 91},
                { 18, 45, 62, 38, 4, 27, 52, 94, 11, 92, 24, 86, 51, 60, 78, 31},
            };

        int[] chosentrio = new int[16];
        for(int i = 0; i < 16; i++){
            Random randy = new Random(numbers[i]);
            //System.out.println(randy.nextInt(11)+1);
            chosenminuet[i] = minuet[randy.nextInt(11)][i];
        }
        //print(chosenminuet);
        WavAppender.splice("./AudioFiles/"+"M"+chosenminuet[0]+".wav","AudioFiles/"+"M"+chosenminuet[1]+".wav","./Temp/"+0+".wav");
        for(int i = 0; i<15; i++){
            WavAppender.splice("./Temp/"+(i)+".wav","./AudioFiles/"+"M"+chosenminuet[i+1]+".wav","./Temp/"+(i+1)+".wav");
        }

        for(int i = 0; i < 16; i++){
            Random randy = new Random(numbers[i]*numbers[i]);
            //System.out.println(randy.nextInt(11)+1);
            chosentrio[i] = trio[randy.nextInt(6)][i];
        }
        //print(chosentrio);

        WavAppender.splice(".\\AudioFiles\\"+"T"+chosentrio[0]+".wav",".\\AudioFiles\\"+"T"+chosentrio[1]+".wav",".\\Temp\\"+16+".wav");
        for(int i = 16; i<31; i++){
            WavAppender.splice(".\\Temp\\"+(i)+".wav",".\\AudioFiles\"+"T"+chosentrio[i+1-16]+".wav",".\\Temp\\"+(i+1)+".wav");
        }
        WavAppender.splice(".\\Temp\\15.wav",".\\Temp\\31.wav",".\\Temp\\Complete.wav");

        System.out.println("\nWould you like to save this piece? Enter true or false");
        JukeBox juke = new JukeBox(".\\Temp\\Complete.wav");
        juke.play();

        boolean trip = false;
        boolean shouldSave = false;
        while(!trip){
            try{
                Scanner yeet = new Scanner(System.in);
                shouldSave = yeet.nextBoolean();
                trip = true;
            } catch (Exception e){
                System.out.println("\fPlease enter true if you would like to save your piece.\nOr, enter false to end this session");
            }
        }

        if(shouldSave){
            File src = new File(".\\Temp\\Complete.wav");
            String Filename="..\\SavedAudio_"+originalname+".wav";
            File target = new File(Filename);
            System.out.println("this is the path your saving to: "+ Filename);

            try{ //https://stackoverflow.com/questions/106770/standard-concise-way-to-copy-a-file-in-java
                Files.copy(src.toPath(), target.toPath(), StandardCopyOption.REPLACE_EXISTING);
                System.out.println("File saved succesfully! Find it in the SavedAudio folder. See ya later");
            } catch (Exception e) {System.out.println("Copying failed. Try again or contact Aaron.\nThis is likely the result of you using any of the following characters in your name \\ / : ?  \" < > | ");}
        }
        else{
            System.out.println("\nSee ya!");
        }

        //This tries to clear up some space but it does not always work. It tries to delete the temporary files.
        for(int i = 0; i<31; i++){
            File file = new File(".\\Temp\\"+i+".wav");
            file.delete();
            //System.out.println(i+":"+file.delete());
        }
    }

    public static void print(int[] yeet){
        System.out.print("{");
        for(int x: yeet){
            System.out.print(x+", ");
        }
        System.out.println("}");
    }
}