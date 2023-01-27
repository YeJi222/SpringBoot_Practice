package studio.thinkground.AroundHubSpringBoot.data.service;

import studio.thinkground.AroundHubSpringBoot.data.dto.ProductDto;

public interface ProductService {
    ProductDto saveProduct(String productId, String productName, int productPrice, int productStock);
    ProductDto getProduct(String productId);
}
