String regex = 
        "={12}\n" +   // twelve '=' marks and new line mark
        "(.+?)" +     // minimal match that has
        "\n={12}\n" + // new line mark with twelve '=' marks after it
        "(.+?)(?=\n={12}|$)"; // minimal match that will have new line
                              // character and twelve `=` marks after
                              // it or end of data $