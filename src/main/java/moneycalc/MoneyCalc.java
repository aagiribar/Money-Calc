
package moneycalc;

import persistance.file.CurrencyLoaderFile;
import java.util.List;
import model.Currency;
import model.ExchangeRate;
import persistance.res.ExchangeRateLoaderWebService;

public class MoneyCalc {

    public static void main(String[] args) {
        CurrencyLoaderFile clf = new CurrencyLoaderFile("currencies");
        List<Currency> listCurrency = clf.currencyLoader();
        for(Currency currency : listCurrency) {
            System.out.println(currency.getName() + " - " +
                               currency.getCode() + " - " +
                               currency.getSymbol());
        }
        ExchangeRateLoaderWebService lws = new ExchangeRateLoaderWebService();
        for(Currency currencyFrom : listCurrency) {
            for (Currency currencyTo : listCurrency) {
                if(currencyFrom.getCode().equals(currencyTo.getCode())) continue;
                ExchangeRate exchangeRate = lws.ExchangeRateLoader(currencyFrom, currencyTo);
                System.out.println(currencyFrom.getCode() + " - " +
                                   currencyTo.getCode() + " - " +
                                   exchangeRate.getExchange());
            }
        }
    }
}
