package com.railway.reservation.Repository;

import com.railway.reservation.Model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketReservationRepository extends MongoRepository<Ticket, Integer> {

    public Optional<Ticket> findByTicketId(int ticketId);

    public void deleteByTicketId(int ticketId);

    public void findTicketByPNR(String PNR);

}
