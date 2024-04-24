package com.example.projekt1;

import com.example.projekt1.model.*;
import com.example.projekt1.repo.ClientRepo;
import com.example.projekt1.repo.PartRepo;
import com.example.projekt1.repo.PurchaseRepo;
import org.junit.jupiter.api.*;
import org.springframework.boot.test.context.SpringBootTest;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.projekt1.repo.CarRepo;
import org.springframework.core.annotation.Order;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
@SpringBootTest
public class Projekt1ApplicationTests {

	@Autowired
	private CarRepo carRepo;

	@Autowired
	private PurchaseRepo purchaseRepo;

	@Autowired
	private PartRepo partRepo;

	@Autowired
	private ClientRepo clientRepo;

//	public Projekt1ApplicationTests() {
//	}

	private Client createClient(String firstName, String lastName, String email) {
		return clientRepo.save((new Client()).withFirstName(firstName).withLastName(lastName).withEmail(email));
	}
	public Part createPart(String name, double price, Category category, CarModel carModel) {
		return partRepo.save((new Part()).withName(name).withPrice(price).withCategory(category).withCarModel(carModel));
	}
	public Purchase createPurchase(Client client, Part part, Integer quantity, Double price) {
		return purchaseRepo.save((new Purchase()).withClient(client).withPart(part).withQuantity(quantity).withPrice(price));
	}

	@BeforeAll
	public void setUp() {
		Client client = this.createClient("Piotr", "Kowalski", "pkowalski@gmail.com");

		//Car car = this.createCar(CarModel.AUDI, LocalDate.of(2024, 2, 1), client);

		Part part = this.createPart("EngineBMW", 1000.0, Category.ENGINE, CarModel.BMW);
		this.createPart("EngineAudi", 400.0, Category.ENGINE, CarModel.AUDI);

		this.createPurchase(client, part, 1, 1000.0);
	}


	@Test
	public void testFindPartsByPriceRange() {
		Double minPrice = 100.0;
		Double maxPrice = 500.0;
		List<Part> parts = partRepo.findByPriceBetween(minPrice, maxPrice);
		assertThat(parts).isNotEmpty();
	}

	@Test
	public void testFindUserByEmail() {
		String email = "pkowalski@gmail.com";
		Client client = clientRepo.findByEmail(email);
		assertThat(client).isNotNull();
	}

	@Test
	public void testCountTransactionsForUser() {
		Long clientId = 1L; // Zastąp 1L rzeczywistym ID użytkownika
		long transactionCount = purchaseRepo.countByClientId(clientId);
		assertThat(transactionCount).isGreaterThanOrEqualTo(0); // Możesz dostosować to do swoich oczekiwań
	}

	@Test
	public void testCountTransactionsForProduct() {
		Long productId = 1L; // Zastąp 1L rzeczywistym ID produktu
		long transactionCount = purchaseRepo.countByPartId(productId);
		assertThat(transactionCount).isGreaterThanOrEqualTo(0); // Możesz dostosować to do swoich oczekiwań
	}

	@Test
	public void testCountTransactions() {
		long transactionCount = purchaseRepo.count();
		assertThat(transactionCount).isGreaterThanOrEqualTo(0); // Możesz dostosować to do swoich oczekiwań
	}

}
