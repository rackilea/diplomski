String[] test = {"e1","e2","e3","e4"};

for (int i = 0; i < test.length; i++) {

    for (int j = i + 1; j < test.length; j++) {

        System.out.print(test[i] + " - " + test[j]);

        boolean foundExtra = false;

        for (int k = 0; k < test.length && !foundExtra; k++)
        {
            if (k != j && k != i)
            {
                for (int l = 0; l < test.length; l++)
                {
                    if (l != k && l != j && l != i)
                    {
                        System.out.println(" , " + test[k] + " - " + test[l]);
                        foundExtra = true;
                        break;
                    }
                }
            }
        }
    }
}