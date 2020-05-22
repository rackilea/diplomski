private int getOutlineLvl(Style s) {
    // Heading 1 is lvl 0
    // There are 9 levels, so 9 will be lvl 8
    // So return 9 for normal text
    if (s==null
            || s.getPPr()==null) return 9;

    OutlineLvl outlineLvl = s.getPPr().getOutlineLvl();
    if (outlineLvl==null) return 9;
    return outlineLvl.getVal().intValue();
}