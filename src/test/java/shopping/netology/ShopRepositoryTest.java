package shopping.netology;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class ShopRepositoryTest {

    @Test
    public void testForRemoveOfExistingProduct() {
        ShopRepository shopRepository = new ShopRepository();

        Product product1 = new Product(1, "огурцы", 150);
        Product product2 = new Product(2, "помидоры", 200);
        Product product3 = new Product(3, "лук", 25);
        Product product4 = new Product(4, "морковь", 40);

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        shopRepository.add(product4);

        shopRepository.remove(3);

        Product[] expected = {product1, product2, product4};
        Product[] actual = shopRepository.findAll();

        Assertions.assertArrayEquals(expected, actual);

    }

    @Test
    public void testForNotFoundException() {
        ShopRepository shopRepository = new ShopRepository();

        Product product1 = new Product(1, "огурцы", 150);
        Product product2 = new Product(2, "помидоры", 200);
        Product product3 = new Product(3, "лук", 25);
        Product product4 = new Product(4, "морковь", 40);

        shopRepository.add(product1);
        shopRepository.add(product2);
        shopRepository.add(product3);
        shopRepository.add(product4);


        Assertions.assertThrows(NotFoundException.class,
                () -> shopRepository.remove(7));
    }

}