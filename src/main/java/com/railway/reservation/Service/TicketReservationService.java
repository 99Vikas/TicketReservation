package com.railway.reservation.Service;

import com.railway.reservation.Model.Ticket;
import com.railway.reservation.Repository.TicketReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class TicketReservationService {

    @Autowired
    private TicketReservationRepository ticketReservationRepository;

    public Ticket createTicket(Ticket ticket){
        return ticketReservationRepository.save(ticket);
    }

    public Ticket updateTicket(String ticketId, Ticket ticket){
        Optional<Ticket> ticketData = ticketReservationRepository.findByTicketId(ticketId);
        if(ticketData.isPresent()){
            ticketReservationRepository.save(ticket);
        }
        return ticket;
    }

    public void deleteTicket(String ticketId){
        ticketReservationRepository.deleteByTicketId(ticketId);
    }

    public Ticket getTicketByTicketId(String ticketId){
        Optional<Ticket> ticketData = ticketReservationRepository.findByTicketId(ticketId);
        return ticketData.orElse(null);
    }

}