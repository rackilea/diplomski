@RequestMapping(value = "/log", method = RequestMethod.POST)
@ResponseBody
public String logContent(@Valid Log log, BindingResult bindingResult, Map<String, Object> model) {
    if (log.getInitLine() == 0 && log.getFinalLine() == 0) {
        try {
            fileNumberLines(log);
            log.setContent(getLogContentByRange(0, log.getInitLine(), log.getFinalLine(), logsDir + "/" + log.getFilename()));
        } catch (IOException e) {
            logger.error(e.getMessage());
        }
    } else {
        log.setContent(getLogContentByRange(0, log.getInitLine(), log.getFinalLine(), logsDir + "/" + log.getFilename()));
    }

    model.put("path", logsDir);
    model.put("log", log);
    model.put("currentPage", "logs");
    model.put("root", root);

    return log;//return an Object containing data (or your own Value Object)
}