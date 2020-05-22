for (int i = 0; i <= jobLength; i++) {

            Thread.sleep(100);

            double progress = (stepSize * i) / barLength;
            progressBar.setProgressPercentage(progress);

        }