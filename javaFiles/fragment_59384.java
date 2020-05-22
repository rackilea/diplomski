JFreeChart chart = ChartFactory.createPieChart(
    "Smart Phones Manufactured / Q3 2011",  // chart title
    dataset,            // data
    true,               // legend <<<<<<<<<<
    true,               // tooltips
    false               // no URL generation
);