switch (Choice)
            { //open switch

               case 1:Prompt=GetName(); MyTree.SetRoot(MyTree.AddOne(MyTree.GetRoot(),Prompt));
               break;
               case 2: MyTree.BTSearch(MyTree.GetRoot(),Prompt);
               break;
               case 3: MyTree.DisplayAll(MyTree.GetRoot());
               break;
               case 4: System.out.println("\n Have a nice day");
               break;
               default: System.out.println("\n Invalid Choice");
               break;




            }