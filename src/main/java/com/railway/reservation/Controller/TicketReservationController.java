package com.railway.reservation.Controller;

import com.railway.reservation.Model.Ticket;
import com.railway.reservation.Service.TicketReservationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/tickets")
public class TicketReservationController {

    @Autowired
    TicketReservationService ticketReservationService;

    @PostMapping("/add")
    public Ticket createTicket(@RequestBody Ticket ticket){
        return ticketReservationService.createTicket(ticket);
    }

    @PutMapping("/update/{ticketId}")
    public Ticket updateTicket(@PathVariable String ticketId, @RequestBody Ticket ticket){
        return ticketReservationService.updateTicket(ticketId, ticket);
    }

    @DeleteMapping("/delete/{ticketId}")
    public void deleteTicket(@PathVariable String ticketId){
        ticketReservationService.deleteTicket(ticketId);
    }

    @GetMapping("/get/{ticketId}")
    public Ticket getTicket(@PathVariable String ticketId){
        return ticketReservationService.getTicketByTicketId(ticketId);
    }

}
