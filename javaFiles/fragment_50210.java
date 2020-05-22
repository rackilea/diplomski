if (position < -1) { 
            page.setAlpha(0);

        } else if (position <= 1) { 
            page.setAlpha(1);

            // Counteract the default slide transition
            page.setTranslationX(page.getWidth() * -position);

            //Set Y position to swipe in from top
            float yPosition = position * page.getHeight();
            page.setTranslationY(yPosition);

        } else { 
            page.setAlpha(0);
        }