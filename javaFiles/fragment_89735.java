import java.util.ArrayList;
    import java.util.Arrays;
    import java.util.List;
    import java.util.stream.Collectors;

    public class Blocks {

       public static void main(String[] args) {
          // input parameters
          int nBlocks = 5;
          String wordToFind = "nifty";

          // block sizes may have different number of sides
          // This permits optimization by removing irrelevant letters
          // (which I didn't do).
           String[] blockStrings = { "ffi", "rnnf", "aeif", "drst","vyxksksksksky"
           };
          // Split the blocks into a list of letter arrays
          List<String[]> blocks =
                Arrays.stream(blockStrings).map(s -> s.split("")).collect(
                      Collectors.toList());

          // turn "foobar" into abfoor"
          String[] word = wordToFind.split("");
          String sortedWord =
                Arrays.stream(word).sorted().collect(Collectors.joining());

          int count = 0;
          int[] k = new int[nBlocks];
          String[] w = new String[nBlocks];

          // calculate maximum number of iterations. The product
          // of all the block's faces for n blocks.
          int end = blocks.stream().mapToInt(a -> a.length).reduce(1,
                (a, b) -> a * b);

          for (int ii = 0; ii < end; ii++) {

             List<Integer> usedBlockPositions = new ArrayList<>();
             for (int i = 0; i < nBlocks; i++) {
                w[i] = blocks.get(i)[k[i]];
                usedBlockPositions.add(k[i]);
             }

             // compare sorted word to sorted "found" word to see if there is
             // a match.
             if (sortedWord.equals(
                   Arrays.stream(w).sorted().collect(Collectors.joining()))) {
                count++;
                System.out.println(Arrays.toString(w) + " " + usedBlockPositions);
             }

             // Bump the indices to the blocks for next try. This is used to
             // index into each block face to get the next letter. Once
             // again, this is written to allow variable faced blocks.
             // k starts out as [0,0,0,0]
             // then goes to [1,0,0,0], [2,0,0,0] etc thru to [n1,n2,n3,n4] where
             // n* is the max number of block faces for given block. The size of
             // k is the number of blocks (this shows 4).
             for (int i = 0; i < k.length; i++) {
                int v = k[i];
                if (v >= blocks.get(i).length - 1) {
                   k[i] = 0;
                }
                else {
                   k[i]++;
                   break;
                }
             }
          }
          String format = count != 1 ? "%nThere were %d combinations found.%n"
            : "%nThere was %d combination found.%n";
          System.out.printf(format, count);
       }
    }