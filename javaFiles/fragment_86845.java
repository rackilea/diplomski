for(i = 1; i <= height.length; i++){
        heightAsString = JOptionPane.showInputDialog("Please Enter The Height Of Person " + i);
        height[i-1] = Double.parseDouble(heightAsString);

        if(height[i-1] > 1.8){
            over18 += 1;
        }

        if(height[i-1] < 1.6){
            under16 += 1;
        }
    }