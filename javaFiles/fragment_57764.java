final Flux<AppointmentCalendarResponse> responseBody = client.get()
                .exchange()
                .expectStatus().isOk()
                .expectHeader().contentType(MediaType.APPLICATION_JSON_UTF8)
                .returnResult(AppointmentCalendarResponse.class)
                .getResponseBody();

        StepVerifier.create(responseBody)
                .assertNext(data -> {
                    CalendarDTO calendarDTO = data.getData();
                    final List<AppointmentDTO> calendarEvents = calendarDTO.getCalendarEvents();
                    assertNotNull(calendarEvents);
                })
        .expectComplete()
        .verify();