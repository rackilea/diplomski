public Shift createShift(final @RequestBody ShiftParams params) {

        User u = userService.findByFirstName(params.text);

        Set<User> userSets = Collections.singleton(u);

        List<Request> requests = u.getRequests();

        if ( requests == null || requests.isEmpty() || hasNoDayOffOnShiftDate(requests, params)) //This creates the shift if the user has no requests
        {
            Shift shift = buildShift(params, userSets);
            shiftService.save(shift);
            return shift;
        } 

        return null;
    }

    private boolean hasNoDayOffOnShiftDate(List<Request> requests, ShiftParams params) {
        final LocalDate shiftStartDate = convertToLocalDate(params.start);

        Optional<Request> request = requests
                .stream()
                .filter(req -> req.getStatus() == Status.Accepted)
                .filter(req -> isDayOffOnShiftDate(req, shiftStartDate))
                .findAny();
        return request.isEmpty();
    }

    private boolean isDayOffOnShiftDate(Request empReq, LocalDate shiftStartDate) {
        //Request start date in LocalDate
        LocalDate reqStartDate = convertToLocalDate(empReq.getDate()).minusDays(1);
        System.out.println("Req start date is " + reqStartDate);

        //Request end date in LocalDate
        int numDays = empReq.getNumDays();
        LocalDate endDateReq = reqStartDate.plusDays(numDays).plusDays(1);
        System.out.println("Request finish date is" + endDateReq);

        if (shiftStartDate.isAfter(reqStartDate) &&
                shiftStartDate.isBefore(endDateReq)) //checks is the user has requested day off
        {
            System.out.println("The employee has requested that day off");
            return true;
        }else {
            return false;
        }
    }

    private Shift buildShift(@RequestBody ShiftParams params, Set<User> userSets) {
        Shift shift = new Shift();
        shift.setStart(params.start);
        shift.setEnd(params.end);
        shift.setUsersShifts(userSets);
        return shift;
    }

    public LocalDate convertToLocalDate(Date dateToConvert) {
        return LocalDate.ofInstant(
                dateToConvert.toInstant(), ZoneId.systemDefault());
    }