package guru.springframework.msscbreweryclient.web.client;

import static org.junit.jupiter.api.Assertions.*;

import java.net.URI;
import java.util.UUID;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import guru.springframework.msscbreweryclient.web.model.BeerDto;

@SpringBootTest
class BreweryClientTest {

	@Autowired
	BreweryClient client;

	@Test
	void testGetBeerById() {
		BeerDto beerDto = client.getBeerById(UUID.randomUUID());
		assertNotNull(beerDto);
	}

	@Test
	void testSaveNewBeer() {
		BeerDto newBeer = BeerDto.builder().beerName("Cacilds").build();
		URI uri = client.saveNewBeer(newBeer);
		assertNotNull(uri);
		System.out.println(uri.toString());
	}

	@Test
	void testUpdateBeerByID() {
		BeerDto beerDto = BeerDto.builder().beerName("Blue Moon").build();
		client.updateBeerById(UUID.randomUUID(), beerDto);
	}
	
	@Test
	void testDeleteBeerById() {
		client.deleteBeerById(UUID.randomUUID());
	}
}
