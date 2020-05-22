WorkDetail workDetailSaved = this.setWorkerData(request, user, workDetail);
emailService.sendMail("SYDA", new String[]{request.getEmail()},
            "SYDA: teile loodi kasutaja",
            "Teile loodi SYDA süsteemi kasutaja. Teie parool on: " + generatedPassword +
                    "\nSisse saate logida kasutades emaili: " + request.getEmail());
return workDetailSaved;