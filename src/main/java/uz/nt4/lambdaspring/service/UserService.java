package uz.nt4.lambdaspring.service;

import org.springframework.stereotype.Service;
import uz.nt4.lambdaspring.dto.ResponseDTO;
import uz.nt4.lambdaspring.dto.UserDTO;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    public static List<UserDTO> userDTOList = new ArrayList<>();

    public ResponseDTO<UserDTO> add(UserDTO user) {
        if(userDTOList.stream().anyMatch(userDTO -> userDTO.getId().equals(user.getId()))) {
            return ResponseDTO.<UserDTO>builder()
                    .code(1)
                    .message("User ID already exists" + user.getId())
                    .build();
        }
        userDTOList.add(user);
        return ResponseDTO.<UserDTO>builder()
                .success(true)
                .message("OK")
                .data(user)
                .build();
    }

    public ResponseDTO<List<UserDTO>> get() {
        if (userDTOList.size()==0) {
            return ResponseDTO.<List<UserDTO>>builder()
                    .message("List empty")
                    .build();
        }
        return ResponseDTO.<List<UserDTO>>builder()
                .success(true)
                .data(userDTOList)
                .build();
    }

    public String deleteById(Integer id) {
        Optional<UserDTO> optional = userDTOList.stream().filter(u -> u.getId().equals(id)).findFirst();
        if (optional.isPresent()) {
            userDTOList.removeIf(userDTO -> userDTO.getId().equals(id));
            return "Deleted";
        }
        return "User with this ID not found";
    }

    public String update(UserDTO user) {
        Integer id = user.getId();
        Optional<UserDTO> optional = userDTOList.stream().filter(u -> u.getId().equals(id)).findFirst();
        if (optional.isPresent()) {
            System.out.println(id);
            System.out.println(optional.get().getName());
            userDTOList.set(id-1, user);
            return "OK";
        }
        return "User with this ID not found";
    }
    
//----------------------------------------------------------
//    public String updateMoney(Integer id, Double money) {
//        for (UserDTO userDTO : userDTOList) {
//            if (userDTO.getId().equals(id)) {
//            }
//        }
//    }

}
