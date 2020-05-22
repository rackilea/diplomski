String[] data = { 
        "Hello.World", 
        "This.Is.A.Test", 
        "The.S.W.A.T.Team",
        "S.w.a.T.", 
        "S.w.a.T.1", 
        "2001.A.Space.Odyssey" };

for (String s : data) {
    System.out.println(s.replaceAll(
            "(?<=(^|[.])[\\S&&\\D])[.](?=[\\S&&\\D]([.]|$))", "")
            .replace('.', ' '));
}