package model;


public class ExchangeRate {
    private final Currency source;
    private final Currency destination;
    private final double exchange;

    public ExchangeRate(Currency source, Currency destination, double exchange) {
        this.source = source;
        this.destination = destination;
        this.exchange = exchange;
    }

    public Currency getSource() {
        return source;
    }

    public Currency getDestination() {
        return destination;
    }

    public double getExchange() {
        return exchange;
    }
    
    
}
