package uz.nt4.lambdaspring.dto;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;

@RequiredArgsConstructor
@Getter
@Setter
public class UserDTO {
    private final Integer id;
    private final String name;
    private final String surname;
    private final Double money;
}
