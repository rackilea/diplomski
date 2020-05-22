OpenIE openIE = new OpenIE(new ClearParser(new ClearPostagger(new ClearTokenizer())), new ClearSrl(), false, false);

    Seq<Instance> extractions = openIE.extract("Obama is the president of the United States");
    Iterator<Instance> iterator = extractions.iterator();
    while (iterator.hasNext()) {
        Instance inst = iterator.next();
        StringBuilder sb = new StringBuilder();
         sb.append(inst.confidence()).append("\t\t")
         .append(inst.extr().arg1().text()).append("\t\t")
         .append(inst.extr().rel().text()).append("\t\t");

        Iterator<Argument> argIter = inst.extr().arg2s().iterator();
        while (argIter.hasNext()) {
            Part arg = argIter.next();
            sb.append(arg.text()).append("; ");
        }
         System.out.println(sb.toString());
    }