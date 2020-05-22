import java.util.*; 

long a = 9; // total loop, 9 means = 65536, 10 means = 131072 ...
long b = 2;  // multiplier, 2 means = 512,1024,2048...
long c = 512; // starting number
long d = 5; // times random text file

String url; 

Bubble bubble;

void setup() {
  url = sketchPath("_numbers/");  

  bubble = new Bubble();
  generateFiles(a, b, c, d);

  boolean runSortTest = false;
  runSortTest = runTest(url, "_results/c_bubble.txt", bubble);

  if (runSortTest) {
    println("Done");
  } else {
    println("Error");
  }
}

boolean generateFiles(long totalLoop, long multiplier, long power, long fileNumber) {
  PrintWriter pw;
  //int orderCount = 1;
  int count = 1;
  //boolean tobeReturned = true;
  try {
    for (int i = 1; i < totalLoop; i = i+1) {   
      for (int j = 1; j < fileNumber+1; j = j+1) {
        pw = createWriter("/_numbers/" + power + "/" + count + ".txt"); 

        for (int k = 0; k < power; k = k+1) { 
          pw.println(randomNumber(0, power));
          //pw.write(int(randomNumber(0, power)) + "\t");
        }
        count++;

        pw.flush(); // Writes the remaining data to the file
        pw.close(); // Finishes the file
      }
      count = 1;
      //orderCount++;
      power *= multiplier;
    }
    //orderCount = 1;
    return  true;
  } 
  catch (Exception e) {
    return false;
  }
}

long randomNumber(long min, long max) {
  long randomN = (long)random(min, (max + 1));
  return randomN;
}

//####################################################################################################
//## Runs the test and produces a log file for each algorithms
//####################################################################################################

boolean runTest(String url, String out, Sort sort) {
  PrintWriter filename;
  boolean tobeReturned = true;
  String beforeSorting = "";
  String afterSorting = "";

  long startTime;
  double timeTaken;
  try {
    filename = createWriter(out);

    for (File directory : new File(url).listFiles()) {
      File[] listOfFiles = directory.listFiles();     
      filename.println("Number of Records: \t" + directory.getName());

      for (File file : listOfFiles) {
        String[] text; 
        int[] number;
        text = loadStrings(file);
        number = int(text);
        if (isSorted(number)) { 
          beforeSorting = "Sorted";
        } else { 
          beforeSorting = "NOT Sorted";
        };

        startTime = startTime();       
        sort.sortInteger(number);        
        timeTaken = stopTime(startTime);

        if (isSorted(number)) { 
          afterSorting = "Sorted";
        } else { 
          afterSorting = "NOT Sorted";
        };

        filename.println("File Set " + file.getName() + ": \t\t" + beforeSorting + ": \t" + afterSorting + ": \t" + timeTaken);
        timeTaken = 0;
        Arrays.fill(text, null);
        number = null;
      }
      filename.println("\n");
    }
    filename.flush();
    filename.close();
  } 
  catch (Exception e) {
    e.printStackTrace();
    tobeReturned = false;
  }
  return tobeReturned;
}



boolean isSorted(int[] array) {
  for (int i = 0; i < array.length-1; i ++) {
    if (array[i] > array[i+1]) {
      return false;
    }
  }
  return true;
}

//####################################################################################################
//## Time comparison
//####################################################################################################

long startTime() {
  return System.nanoTime();
}

double stopTime(long startTime) {
  double finalTime = (System.nanoTime() - startTime)/1000000000.0;
  return finalTime;
}

/*

 Interface
 # Last update: 20 October 2015 
 */

interface Sort {
  public int[] sortInteger(int[] input);
}


/*
 Bubble class, implements Sort interface
 # Last update: 25 October 2015
 */
class Bubble implements Sort {

  Bubble() {
  }

  int[] sortInteger(int[] input) {
    boolean swapped = true;
    int j = 0;
    int tmp;
    while (swapped) {
      swapped = false;
      j++;
      for (int i = 0; i < input.length - j; i++) {                                       
        if (input[i] > input[i + 1]) {                          
          tmp = input[i];
          input[i] = input[i + 1];
          input[i + 1] = tmp;
          swapped = true;
        }
      }
    }
    return input;
  }
}