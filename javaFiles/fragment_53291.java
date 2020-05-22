public void get_user_input() {
        Scanner reader = new Scanner(System.in);
        while (!reader.hasNextInt() && !tree_height<=max_height && tree_height>=min_height) {
            System.out.println("Veuillez entrer la hauteur du sapin à dessiner: ");
            tree_height = reader.nextInt();
            if (!reader.hasNextInt()){
                System.out.println("Veuillez entrer un nombre entier.");
            }else if (tree_height>max_height){
                System.out.println("Veuillez entrer une valeur entre 5 et 40.");
            }else if (tree_height<min_height){
                System.out.println("Veuillez entrer une valeur entre 5 et 40.");
            }
        }
        return int tree_height;
    }