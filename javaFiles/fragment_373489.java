public double average(){
        int scores = 0;
        if (studentcount >= 1)  
            scores += s1.getTestScore(1) + s1.getTestScore(2) + s1.getTestScore(3);
        if (studentcount >= 2)  
            scores += s2.getTestScore(1) + s2.getTestScore(2) + s2.getTestScore(3);
        if (studentcount >= 3)  
            scores += s3.getTestScore(1) + s3.getTestScore(2) + s3.getTestScore(3);
        if (studentcount >= 4)  
            scores += s4.getTestScore(1) + s4.getTestScore(2) + s4.getTestScore(3);
        if (studentcount >= 5)  
            scores += s5.getTestScore(1) + s5.getTestScore(2) + s5.getTestScore(3);
        return (double)scores/(studentcount*3);
    }
}