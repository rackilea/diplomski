/**
 * Read a file example
 * User: mduffy
 * Date: 4/21/2017
 * Time: 7:48 AM
 * @link http://stackoverflow.com/questions/43529600/java-nothing-will-read-in-this-file
 */

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class Project2 {
    public static void main(String[] args) {
        if (args.length > 0) {
            BufferedReader reader = null;
            try (BufferedReader bufferedReader = new BufferedReader(new FileReader(args[0]))) {
                bufferedReader.lines().forEach(System.out::println);
            } catch (FileNotFoundException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }
        } else {
            System.out.println("Usage: Project2 <file>");
        }
    }
}