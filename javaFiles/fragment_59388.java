Double greatestLessThanOne = Double.longBitsToDouble(4607182418800017407L);

// Assert that greatestLessThanOne is indeed the largest double less than 1.
//assert 1.0 == greatestLessThanOne + Math.ulp(greatestLessThanOne);

for (int i = 1; i >= 0; i++)
    if ((int) (greatestLessThanOne * i) == i)
        System.out.println("Exception found: " + i);