package ticketSales.payment;

import ticketSales.models.Ticket;
import ticketSales.models.User;

public class Purchase {
    // Attributes
    private User user;
    private Ticket ticket;
    private Payment payment;

    // Constructor
    public Purchase(User user, Ticket ticket, Payment payment) {
        this.user = user;
        this.ticket = ticket;
        this.payment = payment;
    }

    // Getters and Setters
    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Ticket getTicket() {
        return ticket;
    }

    public void setTicket(Ticket ticket) {
        this.ticket = ticket;
    }

    public Payment getPayment() {
        return payment;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    // Overridden Methods
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Purchase purchase = (Purchase) o;
        return user.equals(purchase.user) && ticket.equals(purchase.ticket) && payment.equals(purchase.payment);
    }

    @Override
    public int hashCode() {
        int result = user.hashCode();
        result = 31 * result + ticket.hashCode();
        result = 31 * result + payment.hashCode();
        return result;
    }

    @Override
    public String toString() {
        return "Purchase{" +
                "user=" + user +
                ", ticket=" + ticket +
                ", payment=" + payment +
                '}';
    }

    // Methods

}
