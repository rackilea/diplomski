public class TestClass {

    public static void main(String[] args) {
        int passed = 0;
        int failed = 0;
        int n = 0; //don't leave uninitialized and uncaptialize
        int grades = 0;  //same here

        while ((passed + failed) < n) { //parens not correct

            if (grades < 6) {//same here and missing brackets
                failed = failed + 1; //can be changed to failed += 1;
            } else
                passed = passed + 1;  //also can be changed using +=

        }
        //System print statements are wrong and variables are never declared or initialized
        System.out.println(passedPerc = f / 30 * 100);//use camelCase don't use capital variables unless they are constants
        System.out.println(failedPerc = p / 30 * 100);//same here

    }
}