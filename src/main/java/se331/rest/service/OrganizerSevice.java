package se331.rest.service;

import org.springframework.data.domain.Page;
import se331.rest.entity.Organizer;

import java.util.List;

public interface OrganizerSevice {
    List<Organizer> getAllOrganizer();
    Page<Organizer> getOrganizer(Integer page, Integer pageSize);
}
