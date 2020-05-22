do {
    lastCompressSize = currentOutput;
    this.runHorizontalCompression(this.output1, this.output2);
    this.output1.clear();
    this.runVerticalCompression(this.output2, this.output1);
    this.output2.clear();
    currentOutput = this.output1.size;
    iterations += 1;
}while (lastCompressSize > currentOutput);

public void runHorizontalCompression(Array<SimpleRect> input,
        Array<SimpleRect> output) {
    input.sort(this.xAxisSort);
    int x2 = -1;
    final SimpleRect newRect = this.rectCache.retreive();
    for (int i = 0; i < input.size; i++) {
        SimpleRect r1 = input.get(i);
        newRect.set(r1);
        x2 = newRect.x + newRect.width;
        for (int j = i + 1; j < input.size; j++) {
            SimpleRect r2 = input.get(j);
            if (x2 == r2.x && r2.y == newRect.y
                    && r2.height == newRect.height) {
                newRect.width += r2.width;
                x2 = newRect.x + newRect.width;
                input.removeIndex(j);
                j -= 1;
            } else if (x2 < r2.x)
                break;
        }
        SimpleRect temp = this.rectCache.retreive().set(newRect);
        output.add(temp);
    }
}

public void runVerticalCompression(Array<SimpleRect> input,
        Array<SimpleRect> output) {
    input.sort(this.yAxisSort);
    int y2 = -1;
    final SimpleRect newRect = this.rectCache.retreive();
    for (int i = 0; i < input.size; i++) {
        SimpleRect r1 = input.get(i);
        newRect.set(r1);
        y2 = newRect.y + newRect.height;
        for (int j = i + 1; j < input.size; j++) {
            SimpleRect r2 = input.get(j);
            if (y2 == r2.y && r2.x == newRect.x
                    && r2.width == newRect.width) {
                newRect.height += r2.height;
                y2 = newRect.y + newRect.height;
                input.removeIndex(j);
                j -= 1;
            } else if (y2 < r2.y)
                break;
        }
        SimpleRect temp = this.rectCache.retreive().set(newRect);
        output.add(temp);
    }
}