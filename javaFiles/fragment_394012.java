if (iBPM >= 50 && iBPM < 60) {
            condition = "Low / weak heart rate";
            conditionColor = Color.parseColor("#2196f3"); //blue
        }
        else if (iBPM >= 60 && iBPM < 79) {
            condition = "Normal resting heart rate";
            conditionColor = Color.parseColor("#689f38"); //green
        }
        else if (iBPM >= 80 && iBPM <= 89) {
            condition = "PreHypertension";
            conditionColor = Color.parseColor("#ffeb3b"); //yellow
        }
        else if (iBPM >= 90 && iBPM <= 99) {
            condition = "High Blood Pressure \n (Hypertension) stage 1";
            conditionColor = Color.parseColor("#ff9800"); //orange
        }
        else if (iBPM >= 100 && iBPM <= 110) {
            condition = "High Blood Pressure \n (Hypertension) stage 2";
            conditionColor = Color.parseColor("#ff5722"); //deep orange
        }