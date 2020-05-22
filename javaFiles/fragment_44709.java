import java.io.FileOutputStream;
import java.io.IOException;
import java.util.*;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

// Java program to print all permutations of a given string. 
// **************************************** 
// modify is the number of operators 
// brck_no is the paranthesis combination 
// please change these two values while experimenting 
public class testmcdc {

   static int modify = 5;
   static int brck_no = 1;
   static int[] val = new int[1000];
   //  array declaration as global 
   static int mcdctc = -1;
   static int[][] value = new int[1000][1000];
   static int colval = -1;

   static int rowNum = 0;
   static XSSFSheet sheet;
   static String excelFile = "output.xlsx";

   public static void main(String[] args) {
      // create excel workbook
      XSSFWorkbook workbook = new XSSFWorkbook();
      sheet = workbook.createSheet("Java Books");
      // add header to current sheet 
      List<String> header = Arrays.asList("equal2", "mcd2", "pct", "equal3", "mcd3", "pct3w", "ft_ov", "pct_ov", "mcd_ov", "pct3w_ov");
      addRow(sheet, rowNum++, header);

      for (int i = modify; i <= modify; i++) {
         String p = "";
         for (int j = 0; j <= i; j++) {
            for (int m = 0; m < j; m++) {
               p = p + "&";
            }
            for (int m = 0; m < i - j; m++) {
               p = p + "|";
            }
            printAllPermutations(p);
            p = "";
         }
      }
      //   write workbook to file 
      try {
         FileOutputStream outputStream = new FileOutputStream(excelFile);
         workbook.write(outputStream);
         workbook.close();
      } catch (IOException e) {
         e.printStackTrace();
      }
   }

   static int[] print(char[] temp) {
      //  GENERATING INT VALUES 
      String a = "";
      for (int i = 0; i < temp.length; i++) {
         a = a + temp[i];
      }
      //  -----------------negation changes---------------- 
      int ray = (int) Math.pow(2, modify + 1);
      int neg_var_mat[][] = new int[ray][modify + 2];
      int neg_col_val = 0;
      int min_mcdc_tc[] = new int[(temp.length + 1) * 2];
      int keep_tc = 0;
      mcdctc++;
      String mh = a.replace('|', '0');
      mh = mh.replace('&', '1');
      for (int mh2 = 0; mh2 <= mh.length(); mh2++) {
         String t_val = mh.substring(0, mh2) + "1" + mh.substring(mh2, mh.length());
         int t_val_int = Integer.parseInt(t_val, 2);
         min_mcdc_tc[keep_tc++] = t_val_int;
         String f_val = mh.substring(0, mh2) + "0" + mh.substring(mh2, mh.length());
         int f_val_int = Integer.parseInt(f_val, 2);
         min_mcdc_tc[keep_tc++] = f_val_int;
      }
      int n = min_mcdc_tc.length;
      printDistinct(min_mcdc_tc, n);
      System.out.println();
      colval++;
      final int N = temp.length + 1;
      // ===================INT GENERATION START========================
      for (int i = 0; i < (1 << N); i++) {
         String b = zeroPad(Integer.toBinaryString(i), N) + "";
         char[] arrayA = b.toCharArray();
         char[] arrayB = a.toCharArray();
         StringBuilder sb = new StringBuilder();
         int ii = 0;
         while (ii < arrayA.length && ii < arrayB.length) {
            sb.append(arrayA[ii]).append(arrayB[ii]);
            ++ii;
         }
         for (int j = ii; j < arrayA.length; ++j) {
            sb.append(arrayA[j]);
         }
         for (int j = ii; j < arrayB.length; ++j) {
            sb.append(arrayB[j]);
         }
         ScriptEngineManager sem = new ScriptEngineManager();
         ScriptEngine se = sem.getEngineByName("JavaScript");
         String myExpression = sb.toString();
         List outcomes = findAllOutcomes(myExpression);
         val[i] = (int) outcomes.get(brck_no);
         value[colval][i] = val[i];
         neg_var_mat[neg_col_val][0] = val[i];
         for (int i2 = 0, k = 1; i2 < myExpression.length(); i2 = i2 + 2) {
            if (myExpression.charAt(i2) == '1') {
               String newmut = myExpression.substring(0, i2) + "0" + myExpression.substring(i2 + 1, myExpression.length());
               List outcomes1 = findAllOutcomes(newmut);
               int valdata = (int) outcomes1.get(brck_no);
               neg_var_mat[neg_col_val][k++] = valdata;
            } else {
               String newmut = myExpression.substring(0, i2) + "1" + myExpression.substring(i2 + 1, myExpression.length());
               List outcomes1 = findAllOutcomes(newmut);
               int valdata = (int) outcomes1.get(brck_no);
               neg_var_mat[neg_col_val][k++] = valdata;
            }
         }
         neg_col_val++;
         // $$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$$ 
         //  NEED TO HAVE THESE VALUES IN THE 1-D ARRAY 
      }
      // ===================GENERATION OF INT VALUES STOPS OR BECOMES LOOP==================
      //  PASS VALUES TO CHECK FUNCTION ABOVE 
      //  testmcdc aa=new testmcdc(); 
      //  aa.check(val); 
      //  int neg_var_mat[][]=new int[ray][modify+2]; 
      int pict[] = new int[]{8, 55, 20, 3, 57, 46};
      int pict3w[] = new int[]{2, 49, 31, 39, 44, 24, 43, 13, 1, 50, 62, 20};
      int mcdc[][] = {{32, 0, 16, 8, 4, 2, 1}, {48, 16, 32, 40, 36, 34, 33}, {40, 8, 24, 16, 20, 18, 17}, {36, 4, 20, 12, 8, 10, 9}, {34, 2, 18, 10, 6, 4, 5}, {33, 1, 17, 9, 5, 3, 2}, {56, 24, 40, 48, 52, 50, 49}, {52, 20, 36, 44, 40, 42, 41}, {50, 18, 34, 42, 38, 36, 37}, {49, 17, 33, 41, 37, 35, 34}, {44, 12, 28, 20, 24, 26, 25}, {42, 10, 26, 18, 22, 20, 21}, {41, 9, 25, 17, 21, 19, 18}, {38, 6, 22, 14, 10, 12, 13}, {37, 5, 21, 13, 9, 11, 10}, {35, 3, 19, 11, 7, 5, 6}, {60, 28, 44, 52, 56, 58, 57}, {58, 26, 42, 50, 54, 52, 53}, {57, 25, 41, 49, 53, 51, 50}, {54, 22, 38, 46, 42, 44, 45}, {53, 21, 37, 45, 41, 43, 42}, {51, 19, 35, 43, 39, 37, 38}, {46, 14, 30, 22, 26, 28, 29}, {45, 13, 29, 21, 25, 27, 26}, {43, 11, 27, 19, 23, 21, 22}, {39, 7, 23, 15, 11, 13, 14}, {62, 30, 46, 54, 58, 60, 61}, {61, 29, 45, 53, 57, 59, 58}, {59, 27, 43, 51, 55, 53, 54}, {55, 23, 39, 47, 43, 45, 46}, {47, 15, 31, 23, 27, 29, 30}, {63, 31, 47, 55, 59, 61, 62},};
      int equal2 = 0;
      int equal3 = 0;
      int pct = 0;
      int pct3w = 0;//   pict 
      int mcd2 = 0;
      int mcd3 = 0;//   mcdc 
      int ft_ov = 0;
      int mcd_ov = 0;
      int pct_ov = 0;
      int pct3w_ov = 0;
      for (int h2 = 1; h2 <= (1 + modify); h2++) {
         int count_faults = 0;
         int pict_det = 0;
         int pict3w_det = 0;
         int mcdc_det = 0;
         for (int h3 = 0; h3 < Math.pow(2, modify + 1); h3++) {
            if (neg_var_mat[h3][0] != neg_var_mat[h3][h2]) {
               for (int hh = 0; hh < pict.length; hh++) {
                  if (pict[hh] == h3) {
                     pict_det++;
                  }
               }
               for (int hh = 0; hh < pict3w.length; hh++) {
                  if (pict3w[hh] == h3) {
                     pict3w_det++;
                  }
               }
               for (int hh = 0; hh < mcdc[h2].length; hh++) {
                  if (mcdc[mcdctc][hh] == h3) {
                     mcdc_det++;
                  }
               }
               count_faults++;
            }
         }
         ft_ov += count_faults;
         mcd_ov += mcdc_det;
         pct_ov += pict_det;
         pct3w_ov += pict3w_det;
         //      System.out.println(" Total Faults "+count_faults); 
         //      System.out.println(" Faults Detected by Pict "+pict_det); 
         //      System.out.println(" Faults Detected by MCDC "+mcdc_det); 
         //      System.out.println(" Faults Detected by Pict-3way "+pict3w_det); 
         if (pict_det == mcdc_det) {
            equal2++;
         } else if (pict_det > mcdc_det) {
            pct++;
         } else {
            mcd2++;
         }
         if (pict3w_det == mcdc_det) {
            equal3++;
         } else if (pict3w_det > mcdc_det) {
            pct3w++;
         } else {
            mcd3++;
         }
      }
      //   System.out.println("**************Comparison Between 2-way and MC/DC Testing***********************");  
      //   System.out.println("=########################################################################################################################======"); 
      System.out.print(" " + equal2);
      System.out.print(" " + mcd2);
      System.out.print(" " + pct);
      System.out.print(" " + equal3);
      System.out.print(" " + mcd3);
      System.out.print(" " + pct3w);
      System.out.print(" " + ft_ov);
      System.out.print(" " + pct_ov);
      System.out.print(" " + mcd_ov);
      System.out.println(" " + pct3w_ov);

      //  create new row with computed values:
      List<Integer> data = Arrays.asList(equal2, mcd2, pct, equal3, mcd3, pct3w, ft_ov, pct_ov, mcd_ov, pct3w_ov);
      addRow(sheet, rowNum++, data);

      return val;
   }

   private static void addRow(XSSFSheet sheet, int rowNr, List data) {
      System.out.printf("sheet: adding row #%d%n", rowNr);
      Row row = sheet.createRow(rowNr);
      data.forEach(rowElem -> {
         Cell cell = row.createCell(data.indexOf(rowElem));
         if (rowElem instanceof String) {
            cell.setCellValue((String) rowElem);
         } else if (rowElem instanceof Integer) {
            cell.setCellValue((Integer) rowElem);
         }
      });
   }

   // NO CHANGE NEEDED FROM HERE::THESE FUNC HELPS IN GENERATING EXPRESSION AND EVALUATE THE EXPRESSION............
   static int factorial(int n) {
      int f = 1;
      for (int i = 1; i <= n; i++) {
         f = f * i;
      }
      return f;
   }

   static int calculateTotal(char[] temp, int n) {
      int f = factorial(n);
      //   Building HashMap to store frequencies of  
      //   all characters. 
      HashMap<Character, Integer> hm = new HashMap<Character, Integer>();
      for (int i = 0; i < temp.length; i++) {
         if (hm.containsKey(temp[i])) {
            hm.put(temp[i], hm.get(temp[i]) + 1);
         } else {
            hm.put(temp[i], 1);
         }
      }
      //   Traversing hashmap and finding duplicate elements. 
      for (Map.Entry e : hm.entrySet()) {
         Integer x = (Integer) e.getValue();
         if (x > 1) {
            int temp5 = factorial(x);
            f = f / temp5;
         }
      }
      return f;
   }

   static void nextPermutation(char[] temp) {
      //   Start traversing from the end and 
      //   find position 'i-1' of the first character  
      //   which is greater than its  successor.  
      int i;
      for (i = temp.length - 1; i > 0; i--) {
         if (temp[i] > temp[i - 1]) {
            break;
         }
      }
      //   Finding smallest character after 'i-1' and 
      //   greater than temp[i-1] 
      int min = i;
      int j, x = temp[i - 1];
      for (j = i + 1; j < temp.length; j++) {
         if ((temp[j] < temp[min]) && (temp[j] > x)) {
            min = j;
         }
      }
      //   Swapping the above found characters. 
      char temp_to_swap;
      temp_to_swap = temp[i - 1];
      temp[i - 1] = temp[min];
      temp[min] = temp_to_swap;
      //   Sort all digits from position next to 'i-1' 
      //   to end of the string. 
      Arrays.sort(temp, i, temp.length);
      //   Print the String 
      print(temp);
   }

   static void printAllPermutations(String s) {
      //   Sorting String 
      char temp[] = s.toCharArray();
      Arrays.sort(temp);
      //   Print first permutation 
      print(temp);
      //  System.out.print("** "); 
      //   Finding the total permutations 
      int total = calculateTotal(temp, temp.length);
      for (int i = 1; i < total; i++) {
         nextPermutation(temp);
      }
   }

   static String zero(int L) {
      return (L <= 0 ? "" : String.format("%0" + L + "d", 0));
   }

   static String zeroPad(String s, int L) {
      return zero(L - s.length()) + s;
   }

   static List<Integer> findAllOutcomes(String s) {
      List<Integer> currentResults = new ArrayList<Integer>();
      boolean noOp = true;
      for (int i = 0; i < s.length(); i++) {
         if (s.charAt(i) == '&' || s.charAt(i) == '|') {
            noOp = false;
            List<Integer> left = findAllOutcomes(s.substring(0, i));
            List<Integer> right = findAllOutcomes(s.substring(i + 1));
            for (Integer l : left) {
               for (Integer r : right) {
                  currentResults.add(evaluate(s.charAt(i), l, r));
               }
            }
         }
      }
      if (noOp) {
         currentResults.add(Integer.parseInt(s));
      }
      return currentResults;
   }

   static int evaluate(char operator, int lhs, int rhs) {
      if (operator == '|') {
         return lhs | rhs;
      } else {
         return lhs & rhs;
      }
   }

   static void printDistinct(int arr[], int n) {
      //   Pick all elements one by one 
      for (int i = 0; i < n; i++) {
         //   Check if the picked element  
         //   is already printed 
         int j;
         for (j = 0; j < i; j++) {
            if (arr[i] == arr[j]) {
               break;
            }
         }
      }
   }
}