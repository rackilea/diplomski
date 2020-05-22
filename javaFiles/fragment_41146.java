Dimensions searchDimensions = Arrays.stream(dimensions).collect(Dimensions::new, (dimension, dimension2) -> {
            dimension.endX = dimension.endX < dimension2.endX ? dimension.endX : dimension2.endX;
            dimension.endY = dimension.endY < dimension2.endY ? dimension.endY : dimension2.endY;
            dimension.startX = dimension.startX > dimension2.startX ? dimension.startX : dimension2.startX;
            dimension.startY = dimension.startY > dimension2.startY ? dimension.startY : dimension2.startY;
        }, (dimension, dimension2) -> {
            dimension.endX = dimension.endX < dimension2.endX ? dimension.endX : dimension2.endX;
            dimension.endY = dimension.endY < dimension2.endY ? dimension.endY : dimension2.endY;
            dimension.startX = dimension.startX > dimension2.startX ? dimension.startX : dimension2.startX;
            dimension.startY = dimension.startY > dimension2.startY ? dimension.startY : dimension2.startY;
        });

return applyInBetween(inputArray, function, searchDimensions.startX, searchDimensions.startY, searchDimensions.endX, searchDimensions.endY);