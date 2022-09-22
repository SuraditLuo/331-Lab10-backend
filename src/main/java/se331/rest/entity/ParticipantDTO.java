package se331.rest.entity;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class ParticipantDTO {
    Long id;
    String name;
    List<ParticipantEventHistoryDTO> eventHistory = new ArrayList<>();
}
