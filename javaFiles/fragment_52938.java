/**
     * Simply selects the home view to render by returning its name.
     * @throws Exception 
     */
    @RequestMapping(value = "/", method = RequestMethod.GET)
    public String home(Locale locale, Model model, HttpServletRequest req) throws Exception {
        logger.info("Welcome home! The client locale is {}.", locale);

        CSVReader reader = new CSVReader(new FileReader(req.getServletContext().getRealPath("/WEB-INF")+"/data.csv"));
        String [] nextLine;
        while ((nextLine = reader.readNext()) != null) {
            // nextLine[] is an array of values from the line
            System.out.println(nextLine[0] + nextLine[1] + "etc...");
        }

        Date date = new Date();
        DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);

        String formattedDate = dateFormat.format(date);

        model.addAttribute("serverTime", formattedDate );

        return "home";
    }