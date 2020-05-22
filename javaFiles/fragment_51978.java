import org.hamcrest.core.StringContains;
import org.junit.Assert;

...

String expectedSubString1 = "Got it. I've added this task:"; 
String expectedSubString2 = "[Event][✗] Project Meeting (at: 28/08/19 1600 - 28/08/19 1800)";
String expectedSubString3 = "Now you have 1 task in the list";

...
String result = outContent.toString();
Assert.assertThat(result, StringContains.containsString(expectedSubString1));
Assert.assertThat(result, StringContains.containsString(expectedSubString2));
Assert.assertThat(result, StringContains.containsString(expectedSubString3));