public static void main(String[] arg) {

    double min_value = -100;
    double max_value = 100;

    double m_value = generate_random(max_value, min_value);
    double x_value = generate_random(max_value, min_value);
    double b_value = generate_random(max_value, min_value);
    double y_value = generate_random(max_value, min_value);
    Scanner user_input = new Scanner(System.in);
    int user_answer_int = 0;

    while ((user_answer_int < 4) && (user_answer_int >= 0)) {
      System.out.println("Select 1 to Solve for Y, 2 to Solve for M, 3 to Solve for B and 4 to quit. ");
      user_answer_int = user_input.nextInt();
      int i = 0;
      if (user_answer_int == 1) {
        while (i < 3){
          if (check_answer_for_y(generate_random(max_value, min_value), generate_random(max_value, min_value), generate_random(max_value, min_value))) {
            i++;
          }
          else {
            i = 0;
          }
        }
      }
      else if (user_answer_int == 2) {
        while (i < 3){
          if (check_answer_for_m(generate_random(max_value, min_value), generate_random(max_value, min_value), generate_random(max_value, min_value))) {
            i++;
          }
          else {
            i = 0;
          }
        }
      }
      else if (user_answer_int == 3) {
        while (i < 3){
          if (check_answer_for_b(generate_random(max_value, min_value), generate_random(max_value, min_value), generate_random(max_value, min_value))) {
            i++;
          }
          else {
            i = 0;
          }
        }
      }
      else {
        System.out.println("You are done");
      }
    }
  }
  static boolean check_answer_for_m(double x_value, double y_value, double b_value) {
    System.out.println("Solve For M Problem ");
    System.out.println("Given: ");
    System.out.println("b = " + b_value);
    System.out.println("x = " + x_value);
    System.out.println("y = " + y_value);

    System.out.print("What is the value of m? ");
    Scanner user_input = new Scanner(System.in);
    String user_answer_m = "";
    user_answer_m = user_input.next();
    int user_answer_int = Integer.parseInt(user_answer_m);

    int correct_answer_m = (((int)y_value - (int)b_value) / (int)x_value);

    if (user_answer_int == correct_answer_m){
      System.out.println("You are correct!");
      return true;
    } else {
      System.out.print("Sorry, that is incorrect. ");
      System.out.println("The answer is " + correct_answer_m);
      return false;

    }

  }
  static boolean check_answer_for_b(double m_value, double x_value, double y_value) {
    System.out.println("Solve For B Problem ");
    System.out.println("Given: ");
    System.out.println("m = " + m_value);
    System.out.println("x = " + x_value);
    System.out.println("y = " + y_value);

    System.out.print("What is the value of b? ");
    Scanner user_input = new Scanner(System.in);
    String user_answer_b = "";
    user_answer_b = user_input.next();
    int user_answer_int = Integer.parseInt(user_answer_b);

    int correct_answer_b = ((int)y_value - ((int)m_value * (int)x_value));

    if (user_answer_int == correct_answer_b){
      System.out.println("You are correct!");
      return true;
    } else {
      System.out.print("Sorry, that is incorrect. ");
      System.out.println("The answer is " + correct_answer_b);
      return false;
    }
  }

  static boolean check_answer_for_y(double m_value, double x_value, double b_value) {
    System.out.println("Solve For Y Problem ");
    System.out.println("Given: ");
    System.out.println("m = " + m_value);
    System.out.println("x = " + x_value);
    System.out.println("b = " + b_value);

    System.out.print("What is the value of y? ");

    Scanner user_input = new Scanner(System.in);
    String user_answer_y = "";
    user_answer_y = user_input.next();
    int user_answer_int = Integer.parseInt(user_answer_y);

    int correct_answer_y = (int) m_value * (int) x_value + (int) b_value;

    if (user_answer_int == correct_answer_y) {
      System.out.println("You are correct!");
      return true;
    } else {
      System.out.print("Sorry, that is incorrect. ");
      System.out.println("The answer is " + correct_answer_y);
      return false;

    }
  }
  static int generate_random(double max_value, double min_value) {

    return (int) ((int) (Math.random() * ((max_value - min_value)+ 1)) + min_value);
  }