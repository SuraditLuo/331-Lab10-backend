package se331.rest.entity;

import lombok.*;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class EventOrganizerDTO {
    Long id;
    String name;
}
