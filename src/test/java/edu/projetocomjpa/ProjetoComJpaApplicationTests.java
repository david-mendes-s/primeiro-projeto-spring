package edu.projetocomjpa;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import edu.projetocomjpa.model.User;

@SpringBootTest
class ProjetoComJpaApplicationTests {

	@Test
	void contextLoads() {
		User p1 = new User();
		List<User> userRepository = new ArrayList<>();

        p1.setName("David");
        p1.setUserName("davidmendess");
        p1.setPassword("qwe123");

        userRepository.add(p1);

        for(User u: userRepository){
            System.out.println(u);
			Assertions.assertEquals(userRepository.get(0), u);
        };


	}

}
