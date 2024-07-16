package net.chimaek.day0716_restapi;


import java.util.List;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/users")
public class UserController {

    @GetMapping
    public List<User> getAllUsers() {
        // 전체 사용자 목록 조회
        return null;
    }

    @PostMapping
    public User createUser(@RequestBody User user) {
        // 사용자 생성 로직
        return null;
    }

    @GetMapping("/{id}")
    public User getUserById(@PathVariable("id") Long id){
        // 특정 사용자를 찾기.
        return null;
    }

    @PutMapping("/{id}")
    public User updateUser(@PathVariable("id") Long id,@RequestBody User updateUser){
        // 업데이트 로직
        return null;
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable("id") Long id){
        // 사용자 삭제 메서드

    }
}