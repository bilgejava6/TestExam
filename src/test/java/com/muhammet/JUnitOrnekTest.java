package com.muhammet;

import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS)
public class JUnitOrnekTest {

    /**
     * Test İŞlemlerinin Yaşam Döngüsü
     */

    private String ad= "Muhammet";

    /**
     * Herbir test methodu için çalışmadan önce yapılması gereken
     * işlemeleri tekrar tekrar yapar.
     */
    @BeforeAll
    void initAll(){
        System.out.println("İlk önce Ben çalışırım");
    }
    @BeforeEach
    void init(){
        ad = "Muhammet";
        System.out.println("BeforeEach Çalıştı");
    }
    @Test
    void EqSayiTesti(){
        int s1 = 5;
        int s2 = 5;
        Assertions.assertEquals(s1,s2);
        System.out.println("EqSayiTesti Çalıştı");
    }

    @Test
    void TrueTest(){
        Assertions.assertTrue(ad.startsWith("M"));
        System.out.println("TrueTest Çalıştı");
    }


    /**
     * Tüm testlerden sonra tekar tekrar yapılması gereken işlemleri
     */
    @AfterEach
    void finish(){
        System.out.println("Test Bitti");
    }


    @AfterAll
    void finishAll(){
        System.out.println("Son olarak Ben çalışırım");
    }

}
