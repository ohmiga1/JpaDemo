package com.example.JpaDemo.repository;

import com.example.JpaDemo.JpaDemoApplication;
import com.example.JpaDemo.JpaDemoApplicationTests;
import com.example.JpaDemo.model.entity.Person;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.web.WebAppConfiguration;

import javax.transaction.Transactional;
import java.time.LocalDateTime;
import java.util.Optional;

@WebAppConfiguration
public class PersonRepositoryTest extends JpaDemoApplicationTests {

    @Autowired
    private PersonRepository personRepository;

    @Test
    public void create() {
        Person p = new Person();
        p.setName("Son");
        p.setEmail("Son@nate.com");
        p.setCreateAt(LocalDateTime.now());
        p.setCreateBy("Test");

        System.out.println(p.toString());
        personRepository.save(p);
    }

    //디버깅 (어디에.... 문제 발생했을까? 찾아요..!!)
    //단위테스트(내 코드에 대한 확신이 있어! 이걸 증명하기 위해서)
    @Test
    public void read(){
        Optional<Person> person = personRepository.findById(1);

        Assertions.assertTrue(person.isPresent());
        //Person p;
        person.ifPresent(p->{
            System.out.println(p);
        });
        System.out.println("종료");
    }

    @Test
    public void update() {
        Optional<Person> person = personRepository.findById(1);
        person.ifPresent( p -> {
            p.setName("kkkkkk");
            personRepository.save(p);
        });
    }

    @Test
    //@Transactional
    public void delete() {
        Optional<Person> person = personRepository.findById(2);
        person.ifPresent(p -> {
            personRepository.delete(p);
        });
    }
}
