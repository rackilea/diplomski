<form th:action="@{/send}" method="get">
   <textarea  th:name="doc" rows="10" cols="100" name="doc"></textarea>
   <button type="submit">Send</button>
</form>

    @GetMapping("/send")
    public String send(@RequestParam(name="doc", required = false) String doc) {
        //change required = false as per requirement
        System.out.println("Doc: "+doc);
        return "textarea-input";
    }