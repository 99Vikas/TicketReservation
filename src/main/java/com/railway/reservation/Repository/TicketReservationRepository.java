package com.railway.reservation.Repository;

import com.railway.reservation.Model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TicketReservationRepository extends MongoRepository<Ticket, String> {

    public Optional<Ticket> findByTicketId(String ticketId);

    public void deleteByTicketId(String ticketId);

    public void findTicketByPNR(String PNR);

}
