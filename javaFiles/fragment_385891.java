// Define a Conditional Formatting rule, which triggers formatting
 // when cell's value is greater or equal than 100.0 and
 // applies patternFormatting defined below.
 HSSFConditionalFormattingRule rule = sheet.createConditionalFormattingRule(
     ComparisonOperator.GE, 
     "100.0", // 1st formula 
     null     // 2nd formula is not used for comparison operator GE
 );

 // Create pattern with red background
 HSSFPatternFormatting patternFmt = rule.cretePatternFormatting();
 patternFormatting.setFillBackgroundColor(HSSFColor.RED.index);

 // Define a region containing first column
 Region [] regions =
 {
     new Region(1,(short)1,-1,(short)1)
 };

 // Apply Conditional Formatting rule defined above to the regions  
 sheet.addConditionalFormatting(regions, rule);