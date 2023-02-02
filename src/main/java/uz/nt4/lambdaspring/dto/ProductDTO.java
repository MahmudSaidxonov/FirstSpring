package uz.nt4.lambdaspring.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@RequiredArgsConstructor
public class ProductDTO {
    private final Integer id;
    private final String name;
    private final Integer price;
    private final Integer amount;


}
