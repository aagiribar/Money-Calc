/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package com.mycompany.moneycalc;

import persistance.file.CurrencyLoaderFile;
import java.util.List;
import model.Currency;
import model.ExchangeRate;
import persistance.res.ExchangeRateLoaderWebService;

/**
 *
 * @author aagir
 */
public class MoneyCalc {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        CurrencyLoaderFile clf = new CurrencyLoaderFile("currencies");
        List<Currency> listCurrency = clf.currencyLoader();
        for(Currency currency : listCurrency) {
            System.out.println("");
        }
        ExchangeRateLoaderWebService lws = new ExchangeRateLoaderWebService();
        for(Currency currencyFrom : listCurrency) {
            for (Currency currencyTo : listCurrency) {
                if(currencyFrom.getCode().equals(currencyTo.getCode())) continue;
                ExchangeRate exchangeRate = lws.ExchangeRateLoader(currencyFrom, currencyTo);
                
            }
        }
    }
}
