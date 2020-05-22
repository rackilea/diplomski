final CsvDataFormat csv = new CsvDataFormat(";");
csv.setLazyLoad(true);
csv.setSkipFirstLine(true);

from(in).unmarshal(csv).split(body()).streaming().parallelProcessing()
                    .bean(validator, "validateNumber")
                    .filter(header(ValidateProcess.Valid).isEqualTo(true))
                    .throttle(tps).bean(validator, "validate")
                    .marshal().csv()
                    .to(out).log("done.").end();