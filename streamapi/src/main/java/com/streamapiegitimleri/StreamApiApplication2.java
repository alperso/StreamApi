package com.streamapiegitimleri;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.logging.Filter;
import java.util.stream.Collectors;

@SpringBootApplication
public class StreamApiApplication2 {
    public static void main(String[] args) {
        SpringApplication.run(StreamApiApplication2.class, args);

        User user1 =new User("Alper","ÖNER",15L);
        User user2 =new User("Berat","Buğra",35L);
        User user3 =new User("Hasan","Kahya",25L);
        User user4 =new User("Demir","Can",25L);
        User user5 =new User("Merve","Huysuz",10L);
        User user6 =new User("Merve","Can",18L);

        List<User> userList = Arrays.asList(user1,user2,user3,user4,user5,user6);

//1- Filter :Bir listeyi bir veya birden çok parametreye göre kısıtlayabiliriz.

        System.out.println("Filter Çalışıyor");
        List<User> findUser= userList.stream()
                .filter(user->(user.getUserName().contains("Alper") && (user.getAge().equals(15L))))
                .collect(Collectors.toList());
        //       .forEach(user->System.out.println(user.getUserName()));
        System.out.println("Filter Durdu");

//2-Map : Her bir nesneye özgü işlemler yapmamızı sağlar.

        System.out.println("Map Çalışıyor");
        List<User> usernameAddedText = userList.stream()
                .map(user->new User(user.getUserName()+"Text",user.getLastName(),user.getAge()))
                .collect(Collectors.toList());

        //usernameAddedText.forEach(System.out::println);

        System.out.println("Map Durdu");
//3-Reduce:Reduce işlemi genelde kümülatif operasyonlarda sıkça kullanılır.
//Bir veri setinde sırayla işlem yapmak istiyorsanız ve bir önceki yaptığınız işlemi
//de dahil etmek istiyorsanız reduce metodunu kullanabilirsiniz.
//Örneğin yukarı da kitap örneğinden yola çıkacak olursak yine aynı
//3 tane kitap nesnemiz olsun ve sayfa sayıları 250 den büyük olanları toplasın.

        //Bir listedeki tüm sayıları toplamak,
        //En büyük ya da en küçük değeri bulmak,
        //Bir listeyi tek bir stringe birleştirmek gibi işlemler için kullanılır.

        //Örn: Kullanıcıların yaşlarının toplamını bulma

        Long totalAge = userList.stream()
                .map(user -> user.getAge())
                .reduce(0L,(age1,age2) -> age1+age2);

        System.out.println("Yaşların toplamı: " + totalAge);

        //Örn: En Büyük Yaşı Bulma
        Long maxAge = userList.stream()
                .map(User::getAge) // Yaşları al
                .reduce(Long.MIN_VALUE, Long::max); // En büyüğünü bul

        System.out.println("En büyük yaş: " + maxAge);

    }
}
