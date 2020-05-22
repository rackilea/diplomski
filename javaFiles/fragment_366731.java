class date {
  @Usage("show the current time")
  @Command
  Object main(
     @Usage("the time format")
     @Option(names=["f","format"])
     String format) {
    if (format == null)
      format = "EEE MMM d HH:mm:ss z yyyy";
    def date = new Date();
    return date.format(format);
  }
}

% date -h
% usage: date [-h | --help] [-f | --format]
% [-h | --help]   command usage
% [-f | --format] the time format

% date -f yyyyMMdd