public boolean intersects(JLabel testa, JLabel testb){
    Area areaA = new Area(testa.getBounds());
    Area areaB = new Area(testb.getBounds());

    return areaA.intersects(areaB.getBounds2D());
}