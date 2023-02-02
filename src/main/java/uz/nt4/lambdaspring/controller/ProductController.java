package uz.nt4.lambdaspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import uz.nt4.lambdaspring.dto.ProductDTO;
import uz.nt4.lambdaspring.dto.ResponseDTO;
import uz.nt4.lambdaspring.service.ProductService;

import java.util.List;

@RestController
@RequestMapping("/product")
@RequiredArgsConstructor
public class ProductController {
    private final ProductService service;

    @GetMapping("/{id}")
    public ResponseDTO<ProductDTO> getById(@PathVariable Integer id) {
        return service.getId(id);
    }

    @PostMapping
    public ResponseDTO<ProductDTO> addProduct(@RequestBody ProductDTO productDTO) {
        return service.add(productDTO);
    }

    @GetMapping
    public ResponseDTO<List<ProductDTO>> getAll() {
        return service.getAllProducts();
    }
}
