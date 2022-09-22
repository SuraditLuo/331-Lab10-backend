package se331.rest.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import se331.rest.service.OrganizerSevice;

@RestController
public class OrganizerController {
    @Autowired
    OrganizerSevice organizerSevice;
    @GetMapping("/organizers")
    ResponseEntity<?> getOrganizers() {
        return ResponseEntity.ok(organizerSevice.getAllOrganizer());
    }
}
