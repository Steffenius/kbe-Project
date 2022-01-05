package kbe.kbeproject.products;/*
 * @author Hitzek, Steffen; Matr.Nr 566507
 * @author Schöbel, Susann; Matr.Nr 571657
 */


import com.opencsv.bean.CsvToBeanBuilder;
import org.springframework.context.annotation.Bean;

import java.io.*;
import java.net.URISyntaxException;
import java.net.URL;
import java.nio.file.Paths;
import java.util.List;

// this class creating objects from csv-file
public class CsvImporter {

    public String resourceFile;

    CsvImporter(String resourceFile) throws URISyntaxException {
        // creating absolute path for given resource-file
        // !!! file must be placed in folder resources !!! otherwise fileNotFoundException
        URL resource = CsvImporter.class.getClassLoader().getResource(resourceFile);
        this.resourceFile = resource.getPath();//file.getAbsolutePath();

    }

    // Method returns a List<Product> where Product is created from Entries in .CSV-resourcefile
    @Bean
    public List<Product> getProductsFromCSV() throws FileNotFoundException {
        return new CsvToBeanBuilder(new FileReader(String.valueOf(this.resourceFile)))
                .withType(Product.class).build().parse();
    }

}