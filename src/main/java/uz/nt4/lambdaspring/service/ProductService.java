package uz.nt4.lambdaspring.service;

import org.springframework.stereotype.Service;
import uz.nt4.lambdaspring.dto.ProductDTO;
import uz.nt4.lambdaspring.dto.ResponseDTO;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    public static List<ProductDTO> productDTOList = new ArrayList<>();

    public ResponseDTO<ProductDTO> add(ProductDTO product) {
        if(productDTOList.stream().anyMatch(productDTO -> productDTO.getId().equals(product.getId()))){
            return ResponseDTO.<ProductDTO>builder()
                    .code(1)
                    .message("Product ID already exists" + product.getId())
                    .build();
        }
        productDTOList.add(product);
        return ResponseDTO.<ProductDTO>builder()
                .success(true)
                .message("OK")
                .data(product)
                .build();
    }

    public ResponseDTO<ProductDTO> getId(Integer id) {
        Optional<ProductDTO> optional = productDTOList.stream().
                filter(productDTO1 -> productDTO1.getId().equals(id)).findFirst();
        return ResponseDTO.<ProductDTO>builder()
                .success(optional.isPresent())
                .message(optional.isPresent() ? "OK" : "Product with this ID not found")
                .code(optional.isPresent() ? 0 : -1)
                .data(optional.orElse(null))
                .build();
    }
}
