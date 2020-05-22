int m_final[][] = new int[m_intermediate_left.length][m_intermediate_left[0].length+m_intermediate_right[0].length];

    // For each row of the final matrix
    for(int i = 0; i < m_final.length; i++) {
      // For each column of the final matrix     
      for (int j = 0; j < m_final[0].length; j++) {
        // If j corresponds to the left columns, add left matrix values 
        if (j < m_intermediate_left[0].length) {
            m_final[i][j] = m_intermediate_left[i][j];
        }
        // If j corresponds to the right columns, add the right matrix values
        else {
            m_final[i][j] = m_intermediate_right[i][j - m_intermediate_left[0].length];
        }
      }
    }

    System.out.println(Arrays.deepToString(m_final));