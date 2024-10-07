package ticketSales.payment;

public abstract class Payment {
    // Attributes
    private String name;

    // Getters e Setters
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Abstract methods
    public boolean pay() {
        return true;
    }
}
