package com.railway.reservation.Service;

import com.railway.reservation.Model.Ticket;
import com.railway.reservation.Repository.TicketReservationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TicketReservationService {

    @Autowired
    private TicketReservationRepository ticketReservationRepository;

    public Ticket createTicket(Ticket ticket){
        return ticketReservationRepository.save(ticket);
    }

    public Optional<Ticket> updateTicket(String ticketId, Ticket ticket){
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

    public Optional<Ticket> getTicketByPNR(String PNR){
        return  ticketReservationRepository.getTicketByPNR(PNR);
    }

    public Ticket updateTicketByPNR(String PNR, Ticket ticket){
        Optional<Ticket> ticketData = ticketReservationRepository.findTicketByPNR(PNR);
        if(ticketData.isPresent()){
            ticketReservationRepository.save(ticket);
        }
        return ticket;
    }

    public List<Ticket> getTicketsByTripScheduleId(String scheduleId){
        return ticketReservationRepository.findTicketByScheduleId(scheduleId);
    }

}