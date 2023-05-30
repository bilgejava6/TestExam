package com.muhammet.islemtest;

public class ErincOdev {

    public int hesaplaKare(int s1,int s2) throws Exception {
        Islem islem = new Islem();
        int toplam = islem.toplam(s1,s2);
        int kare = toplam*toplam;
        return kare;
    }
}
