package ticketSales.payment;

import java.util.Date;

public class Card extends Payment {
    // Atributos
    private String numberCard;
    private String cvv;
    private Date expDate;
    private boolean isCreditCard;

    // Construct
    public Card(String numberCard, String cvv, Date expDate, boolean isCreditCard) {
        this.numberCard = numberCard;
        this.cvv = cvv;
        this.expDate = expDate;
        this.isCreditCard = isCreditCard;
    }

    // Methods
    public boolean pagar(String cvv) {
        if (cvv.equals(this.cvv)) {
            return expDate.after(new Date());
        }
        return false;
    }
}
