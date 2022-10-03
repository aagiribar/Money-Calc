package persistance.res;

import model.Currency;
import model.ExchangeRate;


public interface ExchangeRateLoader {
    public ExchangeRate ExchangeRateLoader(Currency from, Currency to);
}
