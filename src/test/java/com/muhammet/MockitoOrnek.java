package com.muhammet;
import com.muhammet.islemtest.Islem;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static org.mockito.Mockito.*;
public class MockitoOrnek {

    @Test
    void test1(){
        List<String> isimler = new ArrayList<>();
        isimler.add("Ahmet");
        isimler.add("Canan");
        isimler.forEach(System.out::println);
    }

    @Test
    void test1Mock(){
        /**
         * Bir sınıfı taklit eden bir yapısı vardır ve taklit ettiği sınıfın sadece
         * methodlarını barındırır. oluşan nesne içinde arayüzler vardır ancak işlevleri
         * yoktur. Gerekli olduğunda bu işlevleri siz tanımlarsınız.
         */
        List<String> isimler = mock(List.class);
        isimler.add("Ahmet"); // bu işlemler geçersizdir. liste içinde ekleme yapamazlar
        isimler.add("Canan");
        isimler.forEach(System.out::println);
        System.out.println("İŞLEM BİTTİ");
    }

    @Test
    void islemTest() throws Exception {
        Islem islem = new Islem();
        int toplambilgisi = islem.toplam(12,8);
        int kare = toplambilgisi * toplambilgisi;
        Assertions.assertTrue(kare==400);
        System.out.println("kare....: "+kare);
    }
    @Test
    void islemTestMock() throws Exception {
        Islem islem = mock(Islem.class);
        int toplambilgisi = islem.toplam(12,8);
        int kare = toplambilgisi * toplambilgisi;
        System.out.println("kare....: "+kare);
        Assertions.assertTrue(kare==400);
    }

    @Test
    void islemTestMockInsertValue() throws Exception {
        Islem islem = mock(Islem.class);
        /**
         * Eğer birisi islem sınıfının toplam method
         * unu herhangi bir değer ile çağırır ise
         * ona şu sonucu dön
         */
        when(islem.toplam(12,8)).thenReturn(20);
        int toplambilgisi = islem.toplam(12,8);
        int kare = toplambilgisi * toplambilgisi;
        System.out.println("kare....: "+kare);
        Assertions.assertTrue(kare==400);
    }

}
