@RequestMapping(value = "/wife/mood")
public String readWife(Model model, @RequestParam("whatImDoing") String iAm, Locale loc) {
    if (iAm.equals("playingXbox")) {
        model.addAttribute("statusTitle", msgSrc.getMessage("mood.angry", null, loc));
        model.addAttribute("statusDetail", msgSrc.getMessage("mood.angry.xboxdiatribe", null, loc));
    }
    return "moodResult";
}