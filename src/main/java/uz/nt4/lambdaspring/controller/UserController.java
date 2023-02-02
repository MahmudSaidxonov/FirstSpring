package uz.nt4.lambdaspring.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import uz.nt4.lambdaspring.dto.ResponseDTO;
import uz.nt4.lambdaspring.dto.UserDTO;
import uz.nt4.lambdaspring.service.UserService;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
public class UserController {
    private final UserService service;

    @GetMapping
    public ResponseDTO<List<UserDTO>> getUsers() {
        return service.get();
    }

    @PostMapping
    public ResponseDTO<UserDTO> addUser(@RequestBody UserDTO userDTO) {
        return service.add(userDTO);
    }

    @DeleteMapping("/{id}")
    public String deleteUser(@PathVariable Integer id) {
        return service.deleteById(id);
    }

    @PutMapping
    public String updateUser(@RequestBody UserDTO userDTO) {
        return service.update(userDTO);
    }

//    @PutMapping
//    public String updateUserMoney(@RequestParam Integer id, @RequestParam Double money) {
//        return service
//    }
}
