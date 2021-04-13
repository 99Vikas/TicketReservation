package com.railway.reservation.Repository;

import com.railway.reservation.Model.Ticket;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface TicketReservationRepository extends MongoRepository<Ticket, Integer> {

    public Optional<Ticket> findByTicketId(String ticketId);

    public void deleteByTicketId(String ticketId);

    public Optional<Ticket> findTicketByPNR(String PNR);

    public Optional<Ticket> getTicketByPNR(String PNR);

    public List<Ticket> findTicketByScheduleId(String ScheduleId);

}
