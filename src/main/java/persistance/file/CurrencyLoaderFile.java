/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package persistance.file;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import model.Currency;

/**
 *
 * @author aagir
 */
public class CurrencyLoaderFile implements CurrencyLoader {
    private final String fileName;
    
    @Override
    public List<Currency> currencyLoader() {
        List<Currency> list = new ArrayList<>();
        try {
            BufferedReader reader = new BufferedReader(new FileReader(new File(fileName)));
            while(true) {
                String line = reader.readLine();
                if(line == null) break;
                list.add(currencyOf(line));
            }
            
            reader.close();
        } catch (FileNotFoundException ex) {
            System.out.println("CurrencyLoaderFile :: currencyLoader");
            return null;
        } catch (IOException ex) {
            System.out.println("CurrencyLoaderFile :: currencyLoader");
            return null;
        }
        return list;
    }
    
    private Currency currencyOf(String line) {
        String[] split = line.split(",");
        return new Currency(split[0], split[1], split[2]);
    }

    public CurrencyLoaderFile(String fileName) {
        this.fileName = fileName;
    }
    
    
}
