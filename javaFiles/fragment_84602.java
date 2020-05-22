private void eqltri()
        {
            // TODO Auto-generated method stub
            for (int i = 0; i < row; i++)
            {
                for (int j = 0; j <col; j++) 
                {
                    xx=(i+1)*pi;
                    yy=(j+1)*pi;
                    if((xx*t)>yy&& yy<(t*(p-xx)))

                    {
                        matrix[i][j]=matrix[i][j];
                    }
                    else
                    {
                    matrix[i][j]=4; 
                    }
                    //System.out.print(matrix[i][j]);
                }
                //System.out.println();
            }

        }