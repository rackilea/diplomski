885        while (p.getFirstMillisecond() <= axisMax) {
886            float x = (float) valueToJava2D(p.getMiddleMillisecond(), dataArea,
887                    edge);
888            DateFormat df = this.labelInfo[band].getDateFormat();

               df.setTimeZone(timeZone); // Missing timezone setting

889            String label = df.format(new Date(p.getMiddleMillisecond()));
890            long first = p.getFirstMillisecond();
891            long last = p.getLastMillisecond();
892            if (last > axisMax) {