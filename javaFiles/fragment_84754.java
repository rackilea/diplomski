public boolean hasButton(JButton button)
{
    for(int i = 0; i < matrix.length; i++)
    {
        if(matrix[i] != null) for(int j = 0; j < matrix[i].length; j++)
        {
            if(button == matrix[i][j]) return true;
        }
    }

    return false;
}