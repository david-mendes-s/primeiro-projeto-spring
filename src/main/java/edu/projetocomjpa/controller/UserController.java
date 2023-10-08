package edu.projetocomjpa.controller;

import java.util.List;
import java.util.Optional;

import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import edu.projetocomjpa.handler.BusinessException;
import edu.projetocomjpa.model.User;
import edu.projetocomjpa.record.UserDTO;
import edu.projetocomjpa.repository.UserRepository;

@RestController
public class UserController {

    @Autowired
    UserRepository users;

    @GetMapping("/users/index")
    public ResponseEntity<List<User>> index(){
        var allUser = users.findAll();
        return ResponseEntity.ok(allUser);
    }

    @PostMapping("/users")
    public ResponseEntity<User> create(@RequestBody @Valid UserDTO user){
        if(user.name() == "" || user.password() == "" || user.userName() == "")
            throw new BusinessException("dados incompletos");

        User oneUser = new User(user);
        
        users.save(oneUser);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/users/{id}")
    public ResponseEntity<User> delete(@PathVariable("id") String id){
        Optional<User> ub = users.findById(id);

        if(!ub.isPresent()){
            throw new BusinessException("usuário não encontrado");
        }

        users.delete(ub.get());
       
        return ResponseEntity.ok().build();
        
    }

    @PutMapping("/users/{id}")
    public ResponseEntity<User> update(@RequestBody UserDTO user, @PathVariable("id") String id){

        Optional<User> responseUser = users.findById(id);

        responseUser.orElseThrow(()-> new BusinessException("usuário não encontrado"));

        if(!responseUser.isPresent()){
            throw new BusinessException("usuário não encontrado");
        }
        
        responseUser.get().setName(user.name());
        responseUser.get().setUserName(user.userName());
        responseUser.get().setPassword(user.password());

        users.save(responseUser.get());
        
        return ResponseEntity.ok().build();

         
    }


}
