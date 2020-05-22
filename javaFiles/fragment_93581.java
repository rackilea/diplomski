System.out.println("Type numbers: ");
    input = Integer.parseInt(reader.nextLine());

    if (input == endingVariable) {
        average = (double) sum / count;

        System.out.println("Thank you and see you later!");
        System.out.println("The sum is " + sum);
        System.out.println("How many numbers: " + count);
        System.out.println("Average: " + average);
        break;
    } else {
        sum += input;
        count++;
    }