int[] input = { 9, 18, 7, 8, 4, 9, 11, 15, 3, 8 }; // Input items.
Arrays.sort(input); // Sort the items.
int left = 0, right = input.length - 1; // Left and right pointers.
int remainder = 0, limit = 20;

// list of groups.
ArrayList<ArrayList<Integer>> list = new ArrayList<ArrayList<Integer>>();

while (right >= left) 
{
    ArrayList<Integer> subList = new ArrayList<Integer>();
    list.add(subList);
    // Add the current maximum element.
    subList.add(input[right]);
    if (right == left)
        break;
    remainder = limit - input[right];
    right--;

    // Add small elements until limit is reached.
    while (remainder > input[left]) {
        subList.add(input[left]);
        remainder = remainder - input[left];
        left++;
    }

    remainder = 0; // Reset the remainder.
}