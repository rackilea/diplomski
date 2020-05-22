NotificationNewDTO dto  = 
     notificationService
    .findByTransactionId(id) 
    .map(g -> NotificationNewDTO.builder()   // Optional<NotificationNewDTO>
            .id(g.getId()) 
            .status(g.getStatus())                          
            .updated_at(g.getUpdated_at())              
          .build()
     )               
    .orElse(NotificationNewDTO.ofDefaultValue()); // change here

return ResponseEntity.ok(dto); // change here