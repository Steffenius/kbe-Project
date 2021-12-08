package kbe.kbeproject.products;

import kbe.kbeproject.products.Product;
import kbe.kbeproject.products.ProductRepository;
import kbe.kbeproject.services.MehrwertSteuerCalculator;
import kbe.kbeproject.products.CsvImporter;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.Assertions.*;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.FileNotFoundException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductsApplicationTests {

	private static Product testProdukt1;
	private static Product testProdukt2;
	private static MehrwertSteuerCalculator mwstCalc;
	private static List<Product> productList;
	private static CsvImporter importer;

	private static List<String> expectedProducts = new ArrayList<String>();

	@BeforeAll
	public static void init() throws URISyntaxException, FileNotFoundException {
		testProdukt1 =  new Product("pinePhone 13 pro",
				1500.00,
				"sierrablau",
				6.1,
				"A15",
				"512GB",
				3	,
				"Berlin",
				"Ein deutlich leistungsstaerkeres Kamera-System",
				"12 MP Pro Kamera-System",
				2021
		);
		testProdukt2 =  new Product("pinePhone 12",
				799.00,
				"red",
				5.9,
				"A14",
				"128GB",
				3	,
				"Hamburg",
				"Krasses Phone",
				"12 MP Pro Kamera-System",
				2020
		);
		mwstCalc = new MehrwertSteuerCalculator();
		importer = new CsvImporter("pineAppleProducts.csv");
		productList = importer.getProductsFromCSV();
		expectedProducts.add("pinePhone 13 pro");
		expectedProducts.add("pinePhone 13");
		expectedProducts.add("pinePhone 12");
		expectedProducts.add("pinePad pro");
		expectedProducts.add("pinePad air");
		expectedProducts.add("pinePad mini");
		expectedProducts.add("pineBook Air");
		expectedProducts.add("pineBook Pro 13");
		expectedProducts.add("pineBook Pro 14");
		expectedProducts.add("pineBook Pro 16");


	}

	@Test
	void testMehrwertSteuerCalculator1() {
		Double exp = 1785.0;
		Double res = mwstCalc.getMehrwertSteuer(testProdukt1).getPrice();
		assertEquals(exp,res);
	}
	@Test
	void testMehrwertSteuerCalculator2() {
		Double exp = 950.81;
		Double res = mwstCalc.getMehrwertSteuer(testProdukt2).getPrice();
		assertEquals(exp,res);
	}

	@Test
	void testRepository(){
		productList.forEach(product -> assertTrue(expectedProducts.contains(product.getName())));
		productList.forEach(product -> assertFalse(product.getName().equalsIgnoreCase("something")));
	}

}
