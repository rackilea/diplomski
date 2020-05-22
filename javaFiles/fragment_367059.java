List<String> totalScenarios = new ArrayList<>();
List<String> passScenarios = new ArrayList<>();
for(String[] entry:myEnteries)
{
   totalScenarios.add(Arrays.toString(entry));
   passScenarios.add(entry.toString());
}
// writing in html file
modal.addAttribute("title", totalScenarios);
modal.addAttribute("message", passScenarios);