byte[] input = ...
Picture output = Picture.create(width, height, ColorSpace.YUV420);
int[] d0 = output.getData()[0], d1 = output.getData()[1], d2 = output.getData()[2];

for(int i = 0, j0 = 0, j1 = 0, j2 = 0; i < input.length; i += 6, j0 += 4, ++j1 , ++j2) {
    d0[j0    ] = input[i    ] & 0xff;
    d0[j0 + 1] = input[i + 1] & 0xff;
    d0[j0 + 2] = input[i + 2] & 0xff;
    d0[j0 + 3] = input[i + 3] & 0xff;

    d1[j1    ] = input[i + 4] & 0xff;
    d2[j2    ] = input[i + 5] & 0xff;
}