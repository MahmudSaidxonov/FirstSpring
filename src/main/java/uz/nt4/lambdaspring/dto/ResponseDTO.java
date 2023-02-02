package uz.nt4.lambdaspring.dto;

import lombok.*;

import java.util.Date;
import java.util.List;

@Builder
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class ResponseDTO<T> {
    private boolean success;
    private int code;
    private String message;
    private T data;
    private List list;
}