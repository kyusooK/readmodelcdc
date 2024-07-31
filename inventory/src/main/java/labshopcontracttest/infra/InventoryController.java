package labshopcontracttest.infra;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class InventoryController {

    @Autowired
    InventoryRepository inventoryRepository;

    @Autowired
    private RestTemplate restTemplate;

    private String apiUrl;

    // consumer

    // Provider
    @GetMapping("/inventories/search/findByGetInventory")
    public ResponseEntity<List<Inventory>> inventoryStockCheck() {
        Iterable<Inventory> inventoryIterable = inventoryRepository.findAll();
        List<Inventory> inventories = StreamSupport
            .stream(inventoryIterable.spliterator(), false)
            .collect(Collectors.toList());
        return ResponseEntity.ok().body(inventories);
    }
}
