package edu.projetocomjpa;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import edu.projetocomjpa.model.User;
import edu.projetocomjpa.repository.UserRepository;


@Component
public class App implements CommandLineRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(String... args) throws Exception {
        User p1 = new User();

        p1.setName("David");
        p1.setUserName("davidmendess");
        p1.setPassword("qwe123");

        System.out.println(p1);

        userRepository.save(p1);

        for(User u: userRepository.findAll()){
            System.out.println(u);
        };
    }

}
