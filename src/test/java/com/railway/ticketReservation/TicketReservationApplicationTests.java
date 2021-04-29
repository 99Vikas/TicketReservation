package com.railway.ticketReservation;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.Optional;

import com.railway.ticketReservation.model.Ticket;
import com.railway.ticketReservation.repository.TicketsRepo;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = WebEnvironment.RANDOM_PORT)
public class TicketReservationApplicationTests {

    @Autowired
    private TicketsRepo ticketsRepo;

    @Test
    @DisplayName("Test for finding ticket by id")
    public void getByIdTest() {

        String id = "6089cf05e476fa377bcab23d";

        Optional<Ticket> testTicket = ticketsRepo.findByTicketId(id);

        assertNotNull(testTicket);
    }

    @Test
    @DisplayName("Test for getting PNR in Ticket Booking")
    public void getPNRTest() {
        String pnr = "20210414SL1";
        Optional<Ticket> testPnr = ticketsRepo.getTicketByPNR(pnr);

        assertNotNull(testPnr);
    }

    @Test
    @DisplayName("Test for finding by pnr")
    public void findByPNR() {
        String pnr = "20210414SL1";
        Optional<Ticket> testPnr = ticketsRepo.findTicketByPNR(pnr);

        assertNotNull(testPnr);
    }
}
