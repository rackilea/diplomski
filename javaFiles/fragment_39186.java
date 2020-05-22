public void cambiarAReservas() {
    this.remove(panelContabilidad);
    this.add(panelReservas, BorderLayout.CENTER);
    this.pack();
}

public void cambiarAContabilidad() {
    this.remove(panelReservas);
    this.add(panelContabilidad, BorderLayout.CENTER);
    this.pack();
}