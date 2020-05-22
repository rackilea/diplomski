while (iter.hasNext()){
            lastEndTime = iter.next().endDateTime;

            if (count > 0)
            {
                if (iter.next().startDateTime.isAfter(lastEndTime))

             ............................