public static void printTable(int status, double taxableIncome){
        double tax1,tax2,tax3,tax4;
        for ( taxableIncome=50000;taxableIncome<60000;taxableIncome =taxableIncome+50){         
            tax1 = 8350*0.10+(33950-8350)*0.15+(taxableIncome-33950);
            tax2 = 16700*0.10+(taxableIncome-16700)*0.15;
            tax3 = 8350*0.10+(33950-8350)*0.15+(taxableIncome-33950);
            tax4 = 11950*0.10+(45500-11950)*015+(taxableIncome-45500);

            if (taxableIncome>=50000 && taxableIncome<=60000){
                System.out.println(Math.round(taxableIncome)+"  "+Math.round(tax1)+"  "+Math.round(tax2)+"  "+Math.round(tax3)+"  "+Math.round(tax4));
            }
        }

    }