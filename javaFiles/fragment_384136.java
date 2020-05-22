for (Habitacion habitacion : reserva.getHabitaciones()){
            habitacion.setReserva(reserva);
        }
        for (Pago pago : reserva.getPagos()){
            pago.setReserva(reserva);
        }
        Usuario usuario = reserva.getUsuario();
        usuario.setReserva(reserva);