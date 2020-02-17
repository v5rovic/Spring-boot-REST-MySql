package com.vladimir.test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;


@RequestMapping("/")
@RestController
public class UserController {

    @Autowired
    UserRepo userRepo;

    /*
    @GetMapping("all")
    public String showAll(Model model) {
        model.addAttribute("users", userRepo.findAll());
        return "allUsers";
    }
    */

    @GetMapping("all")
    public List<User> showAll() {
        List<User> lista = userRepo.findAll();
        return lista;
    }


    @GetMapping("name/{name}")
    public List<User> getByName(@PathVariable(value = "name") String name) {
        List<User> lista = userRepo.findByName(name);
        return lista;
    }

    @GetMapping("surname/{surname}")
    public List<User> getBySurname(@PathVariable(value = "surname") String surname) {
        List<User> lista = userRepo.findBySurname(surname);
        return lista;
    }

    /*
    @GetMapping("surname/{surname}")
    public String getBySurname(@PathVariable(value = "surname") String surname, Model model) {
        model.addAttribute("users", userRepo.findBySurname(surname));
        return "allUsers";
    }
    */

    @GetMapping("email/{email}")
    public List<User> getByEmail(@PathVariable(value = "email") String email) {
        List<User> lista = userRepo.findByEmail(email);
        return lista;
    }

    /*
    @GetMapping("email/{email}")
    public String getByEmail(@PathVariable(value = "email") String email, Model model) {
        model.addAttribute("users", userRepo.findByEmail(email));
        return "allUsers";
    }
    */

    @PostMapping("save")
    public void createUser(@Valid @RequestBody User user) {
        userRepo.save(user);
    }

    @DeleteMapping("delete/{id}")
    public void deleteUser(@PathVariable(value = "id") Long id) {
        User user = userRepo.findById(id).orElseThrow(() -> new ResourceNotFoundException("User", "id", id));
        userRepo.delete(user);
    }

    }
