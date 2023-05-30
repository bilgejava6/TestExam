package com.muhammet.service;

import com.muhammet.repository.IUserRepository;
import com.muhammet.repository.entity.User;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Optional;

import static org.mockito.Mockito.*;
//@SpringBootTest
@ExtendWith(MockitoExtension.class)
public class UserServiceMockTest {
//    @Autowired
//    private UserService userService;

    /**
     *
     * DİKKAT!!!!
     * Kullanımlar önemli, ilk olarak üzerinde gerçek
     * nesne ile test yapılacak sınıfı belirliyoruz ve
     * ona göre @InjectMock ile işaretliyoruz.
     * devamında bir sınıfın içinde kullanmakta olduğu
     * tüm diğer sınıf implemantasyonlarını (DI leri)
     * @Mock ile işaretliyoruz ve sannalştırmış oluyoruz.
     *
     */
    @InjectMocks
    private UserService userServiceMock;
    @Mock
    private IUserRepository userRepository;
    @Test
    void saveTest(){
        User user = User.builder()
                .email("muhammet@gmail.com")
                .adres("Ankara")
                .ad("Muhammet")
                .telefon("0 55 66 99987")
                .build();

      //  User savedUser = userService.save(user);
        System.out.println(user.toString());
        Assertions.assertTrue(user.getId()!=null);
    }

    @Test
    void saveMockTest(){
        User user = User.builder()
                .email("muhammet@gmail.com")
                .adres("Ankara")
                .ad("Muhammet")
                .telefon("0 55 66 99987")
                .build();
        when(userRepository.findOptionalByAd(any())).thenReturn(
                Optional.empty()
        );
        when(userRepository.save(any())).thenReturn(
           User.builder()
                          .id(125L)
                  .email("muhammet@gmail.com")
                  .adres("Ankara")
                  .ad("Muhammet")
                  .telefon("0 55 66 99987")
                  .build()
        );
        User savedUser = userServiceMock.save(user);
        System.out.println(user.toString());
        Assertions.assertTrue(savedUser.getId()!=null);
    }
}
