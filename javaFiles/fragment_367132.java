StringBuilder narration = new StringBuilder("Receipt No. ");

narration.append(tb.getTally_receipt_no())
         .append(", ").append(tb.getTally_mode());
if (!"Ca".equals(tb.getTally_mode()))
{
    narration.append(", ").append(tb.getTally_instrument_no())
             .append(", ").append(tb.getTally_instrument_date())
             .append(", ").append(tb.getTally_instrument_bank());
}

tb.setTally_narration(narration.toString());