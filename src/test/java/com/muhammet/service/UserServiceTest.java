package com.muhammet.service;

import com.muhammet.repository.entity.User;
import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static java.time.Duration.*;

@SpringBootTest
public class UserServiceTest {
    @Autowired
    private UserService userService;

    @Test
    void saveTestForAcceptableUser() {
        User user = new User();
        user.setAd("Muhammet");
        user.setAdres("Ankara");
        /**
         * Eğer kayıt başarılı olursa hata fırlatmaz ve user içinde id değeri olur
         */
        userService.save(user);
        userService.getAll().forEach(System.out::println);
        assertNotNull(user.getId());
    }

    /****
     * Eğer kullanıcı adı girilmemiş ise sistemin hata fırlatması beklenir
     * bir istisnanın fırlatılıp fırlatılmadığını test eder
     */
    @Test
    void saveTestForNullValue(){
        User user = new User();
        user.setAdres("Ankara");
        Exception exception = assertThrows(RuntimeException.class, ()->{
            userService.save(user);
        });
        assertEquals("Kullanıcı adı boş olamaz",exception.getMessage());
    }
    @Test
    void saveTestForDuplicateUser(){
        User user = new User();
        user.setAd("Deniz");
        user.setAdres("Ankara");
        userService.save(user);
        Exception exception = assertThrows(RuntimeException.class, ()->{
            userService.save(user);
        });
        assertEquals("Bu isimde bir kullanıcı zaten var",exception.getMessage());
    }

    @Test
    void saveTestAddMultipleUser(){
        User user = new User();
        user.setAd("Deniz");
        user.setAdres("Ankara");
        userService.save(user);
        User user2 = new User();
        user2.setAd("Muhammet");
        user2.setAdres("Ankara");
        userService.save(user2);
        User user3 = new User();
        user3.setAd("Mehmet");
        user3.setAdres("Ankara");
        userService.save(user3);
        userService.getAll().forEach(System.out::println);
        assertEquals(3, userService.getAll().size());
    }

    @Test
    void allTestCase(){
        int toplam = 3+1;
        assertEquals(4, toplam);
        assertTrue('a'<'b');
        assertTrue('a'<'b', ()-> "Bilgilendirme mesajı");
        Exception exception = assertThrows(RuntimeException.class, ()->{
            throw new RuntimeException("Hata fırlatıldı");
        });
        assertEquals("Hata fırlatıldı", exception.getMessage());
        //assertTimeout(Duration.ofSeconds());
        assertTimeout(ofSeconds(1),()->{
            Thread.sleep(999);
        });
        assertAll("Topluca işlem yapalım",
                ()-> assertEquals(4, "ayse".length()),
                ()-> assertTrue(2>0),
                ()-> assertNotEquals(5, 5+6)
        );
    }
}
