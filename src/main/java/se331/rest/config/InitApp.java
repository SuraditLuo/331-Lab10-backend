package se331.rest.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;
import se331.rest.entity.Event;
import se331.rest.entity.Organizer;
import se331.rest.entity.Participant;
import se331.rest.repository.EventRepository;
import se331.rest.repository.OrganizerRepository;
import se331.rest.repository.ParticipantRepository;

import java.util.ArrayList;
import java.util.List;


@Component
public class InitApp implements ApplicationListener<ApplicationReadyEvent> {
    @Autowired
    EventRepository eventRepository;
    @Autowired
    OrganizerRepository organizerRepository;
    @Autowired
    ParticipantRepository participantRepository;
    @Override
    @Transactional
    public void onApplicationEvent(ApplicationReadyEvent applicationReadyEvent) {
        Organizer org1, org2, org3;
        org1 = organizerRepository.save(Organizer.builder()
                .name("CAMT")
                .build());
        org2 = organizerRepository.save(Organizer.builder()
                .name("CMU")
                .build());
        org3 = organizerRepository.save(Organizer.builder()
                .name("ChiangMai")
                .build());
        Participant p1, p2, p3, p4, p5;
        p1 = participantRepository.save(Participant.builder()
                .name("Leng")
                .telNo("0810210999")
                .build());
        p2 = participantRepository.save(Participant.builder()
                .name("Joe")
                .telNo("0876254268")
                .build());
        p3 = participantRepository.save(Participant.builder()
                .name("White")
                .telNo("0935428962")
                .build());
        p4 = participantRepository.save(Participant.builder()
                .name("Ball")
                .telNo("0974542201")
                .build());
        p5 = participantRepository.save(Participant.builder()
                .name("Jesse")
                .telNo("0810365778")
                .build());
        Event tempEvent;
        tempEvent = eventRepository.save(Event.builder()
                .category("Academic")
                .title("Midterm Exam")
                .description("A time for taking the exam")
                .location("CAMT Building")
                .date("3rd Sept")
                .time("3.00-4.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org1);
        org1.getOwnEvents().add(tempEvent);
        p1.getEventHistory().add(tempEvent);
        p4.getEventHistory().add(tempEvent);
        p2.getEventHistory().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Loy Krathong")
                .description("A time for Krathong")
                .location("Ping River")
                .date("21th Nov")
                .time("8.00-10.00 pm.")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org2);
        org2.getOwnEvents().add(tempEvent);
        p3.getEventHistory().add(tempEvent);
        p5.getEventHistory().add(tempEvent);
        p4.getEventHistory().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Cultural")
                .title("Songkran")
                .description("Let's Play Water")
                .location("Chiang Mai Moat")
                .date("13th April")
                .time("10.00am - 6.00 pm.")
                .petAllowed(true)
                .build());
        tempEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tempEvent);
        p5.getEventHistory().add(tempEvent);
        p1.getEventHistory().add(tempEvent);
        p2.getEventHistory().add(tempEvent);
        tempEvent = eventRepository.save(Event.builder()
                .category("Food")
                .title("Eating Contest")
                .description("Eat Big Get Big")
                .location("A restaurant")
                .date("3rd July")
                .time("12.00 - 13.30pm")
                .petAllowed(false)
                .build());
        tempEvent.setOrganizer(org3);
        org3.getOwnEvents().add(tempEvent);
        p4.getEventHistory().add(tempEvent);
        p2.getEventHistory().add(tempEvent);
        p5.getEventHistory().add(tempEvent);
        p3.getEventHistory().add(tempEvent);
    }
}
