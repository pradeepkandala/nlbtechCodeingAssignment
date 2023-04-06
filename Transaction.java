package nlbTechCodingAssignment;

class Transaction {
    private final String customer;
    private final String date;
    private final double amount;
    
    public Transaction(String customer, String date, double amount) {
        this.customer = customer;
        this.date = date;
        this.amount = amount;
    }
    
    public String getCustomer() {
        return customer;
    }
    
    public String getDate() {
        return date;
    }
    
    public double getAmount() {
        return amount;
    }
}
