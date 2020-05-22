RectF rect          = attacher.getDisplayRect();
            float viewScale     = attacher.getScale();

            float imageRatio = (float)size.width() / (float)size.height();
            float viewRatio = (float)photoView.getWidth() / (float)photoView.getHeight();

            float scale = 0;
            if (imageRatio > viewRatio) {
                // scale is based on image width
                scale = 1 / ((float)size.width() / (float)photoView.getWidth() / viewScale);

            } else {
                // scale is based on image height, or 1
                scale = 1 / ((float)size.height() / (float)photoView.getHeight() / viewScale);
            }

            // translate to bitmap scale
            rect.left       = -rect.left / scale;
            rect.top        = -rect.top / scale;
            rect.right      = rect.left + ((float)photoView.getWidth() / scale);
            rect.bottom     = rect.top + ((float)photoView.getHeight() / scale);

            if (rect.top<0) {
                rect.bottom -= Math.abs(rect.top);
                rect.top = 0;
            }
            if (rect.left<0) {
                rect.right -= Math.abs(rect.left);
                rect.left = 0;
            }