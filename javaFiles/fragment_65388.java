int number;

            if ([[UIDevice currentDevice] userInterfaceIdiom] == UIUserInterfaceIdiomPad) {
                number = visibleRect.origin.y / <height of each image on iPad in pixels>;
            }
            else {
                number = visibleRect.origin.y / <height of each image on iPhone in pixels>;
            }