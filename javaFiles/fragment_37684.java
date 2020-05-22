for(int j = 0; j < 3; j++) {
    for(int i = 0; i < scat_size.length; i++)
        scat_size[j][i] = i;

    for(int i = 0; i < scat_times.length; i++)
        scat_times[j][i] = i;
}

// This should be 1,1 2,2 3,3 etc. in Red
scatter_values[0] = new TwoArray(scat_size[0], scat_times[0]);

// Trying to test a large co-ord so this should be green
scat_size[1][2] = 70;
scat_times[1][2] = 20;
scatter_values[1] = new TwoArray(scat_size[1], scat_times[1]);

// Trying to test another different co-ord so this should be blue
scat_size[2][2] = 3;
scat_times[2][2] = 7;
scatter_values[2] = new TwoArray(scat_size[2], scat_times[2]);

myScatter = new ScatterPanel(scatter_values, scat_title, color_list);