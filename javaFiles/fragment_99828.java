// [before]
Line 467 bodyPart.setFileName(MimeUtility.encodeText(name));

// [after]
// I would make an option to handle it like this.
Line 467 bodyPart.setFileName(name);