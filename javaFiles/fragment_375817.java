private void updateDurationColor(SpinClassMovement movement){

        String duration = (String) TextFormatUtil.getFormattedTimeInMinutesAndSeconds(movement.getMovementLengthInMinutes() + movement.getMovementLengthInSeconds());
        StringBuilder colorDuration = new StringBuilder();

        for(int i = 0; i < duration.length(); i++){

            if (duration.charAt(i) == '0'){

                Character zero = duration.charAt(i);
                colorDuration.append(zero);

                setColor(mTimeRemaining,duration,colorDuration,Color.GRAY);
            }
        }
    }