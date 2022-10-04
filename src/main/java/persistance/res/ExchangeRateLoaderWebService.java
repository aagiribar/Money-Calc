package persistance.res;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import model.Currency;
import model.ExchangeRate;

public class ExchangeRateLoaderWebService implements ExchangeRateLoader {

    @Override
    public ExchangeRate ExchangeRateLoader(Currency from, Currency to) {
        try {
            return new ExchangeRate(from, to, read(from.getCode(), to.getCode()));
        } catch (MalformedURLException ex) {
            Logger.getLogger(ExchangeRateLoaderWebService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        } catch (IOException ex) {
            Logger.getLogger(ExchangeRateLoaderWebService.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }

    }
    
    private double read(String codeFrom, String codeTo) throws MalformedURLException, IOException {
        URL url = new URL("https://cdn.jsdelivr.net/gh/fawazahmed0/currency-api@1/latest/currencies/" + codeFrom.toLowerCase() + "/" + codeTo.toLowerCase() + ".json");
        return Double.parseDouble(getStringRateFromJSON(read(url)));
    }
    
    private String read(URL url) throws IOException {
        InputStream inputStream = url.openStream();
        byte buffer[] = new byte[1024];
        int length = inputStream.read(buffer);
        return new String(buffer, 0, length);
    }
    
    private String getStringRateFromJSON(String line) {
        String[] split = line.split(",");
        return split[1].substring(split[1].indexOf(":") + 1, split[1].indexOf("}") - 1);
    }
    
}
