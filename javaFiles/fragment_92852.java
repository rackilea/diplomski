TimeClockDto result = new JSONDeserializer<TimeClockDto>
                        .use("data", TimeClockDto.class)
                        .use("data.todayShift", TodayShiftDto.class)
                        .use("data.status", new EnumObjectFactory())
                        .use("data.latestOffice", BaseLocationDto.class)
                        .deserialize(param.getResult(),TimeClockDto.class);