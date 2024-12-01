
        /*
        * Stream Api Nedir?
        *
        * Stream API, Collection(List,Hash,Set...) nesnelerini işlemek için kullanılır.
        * Java 8 ile birlikte gelen bir yenilik olup, koleksiyonlar ve diziler gibi veri yapılarını daha verimli
        * ve fonksiyonel bir şekilde işlemek için tasarlanmış bir API'dir. Stream API, özellikle koleksiyonlar
        * üzerinde işlem yaparken daha az kod yazmanıza ve daha yüksek performans elde etmenize olanak tanır.
        *
        * Veriyi sıralamak,
        * filtrelemek,
        * dönüştürmek,
        * birleştirmek gibi işlemleri kolayca ve okunabilir şekilde yapmanızı sağlar.
        *
        * Stream API Temel Bileşenleri:
            Filter (Filtreleme): Belirli bir koşula göre elemanları filtrelemek.
            Map (Haritalama): Her öğeye bir fonksiyon uygulamak.
            Reduce (Azaltma): Elemanları birleştirerek bir tek değere indirgemek.
            ForEach (Her Eleman İçin İşlem): Her eleman üzerinde işlem yapmak.
            Collect (Toplama): Sonuçları bir koleksiyona toplamak.
        *
        * Stream bir interface olduğundan dolayı doğrudan nesne almaz.
        * Stream stream() ya da parallelStream() metodlarını çağırarak geriye Stream nesnesi döndürebilir.
        * Bir Stream nesnesi oluşturur çeşitli operasyonlardan geçirirsek nesne ile birlikte geçirdiğimiz operasyonların tamamı Stream Pipeline olarak adlandırılır.
        * int , double ve long için IntStream , DoubleStream ve LongStream şeklinde kullanımı bulunmaktadır.
        *
        * parallelStream() nedir?
        *
        * Paralel stream kullanarak, kodumuz sistemin ayrı çekirdeklerinde paralel olarak yürütülebilen birden çok stream a bölünür
        * ve tüm bireysel çekirdeğin sonuçlarının birleşimi olarak gösterilir.
        * Daha net bir ifade ile bir sonraki elemanın işleme girmesi için şuan ki
        * elemanın işlemden çıkması gerekmemektedir.
        *
        * Streamler kullanılırken Java 8 ile birlikte gelen
        * Lambda Expression Syntax’ı kullanılmaktadır.
        *
        * Kullanımı:
        * (argüman listesi) -> {gövde}
        *
        * () -> {...}
        * (a) -> {...}
        * (a,b) -> {...}
        *
        * Örn:
        *
        * (int a,int b) -> {System.out.println(a+b); return a+b;}
        *
        * */

 //forEach : Stream’in tüm öğelerini dolaşmaktır.
        //forEach’ın dönüş tipi void bu yüzden forEach yazdıktan sonra başka bir metot yazılamaz.

        ArrayList<Integer> list =new ArrayList<>();
        list.add(25);
        list.add(12);
        list.add(15);
        list.add(15);
        list.add(2);

        System.out.println("forEach Metodu çalışıyor...");
        list.stream()
                .forEach(item -> System.out.println(item));
        //Bu metodu kullanarak akışın bütün elemanları üzerinde bir işlem yapabilirsiniz.


//filter:Belirli bir koşula göre filtrelemek için kullanırız
        System.out.println("Filter Metodu çalışıyor...");
        list.stream()
                .filter(item->item>10)
                .forEach(item->System.out.println(item));

        //2.yol
        //list.stream()
        //        .filter(item->item>10)
        //       .forEach(System.out::println);


//distinct: Her elemanın en fazla 1 kez yer almasını sağlayabilirsiniz.
        //Eğer akışın içinde bir eleman daha önce tanımlanmışsa, ikinci kez yer almaz. Parametre almaz.
        System.out.println("distinct Metodu çalışıyor...");

        list.stream()
                .distinct()
                .forEach(number->System.out.println(number));

//sorted :Bu metodu kullanarak akışın elemanlarını sıralayabilirsiniz.
        System.out.println("sorted Metodu çalışıyor...");

        //Kucukten Buyuge
        list.stream()
                .sorted()
                .distinct()
                .forEach(item -> System.out.println(item));

        //Buyukten Kucuge
        list .stream()
                .sorted(Comparator.reverseOrder())
                .forEach(number -> System.out.println(number));

//limit : Akış üzerinde gerçekleştireceğiniz işlemleri belli bir sayıyla sınırlandırabilirsiniz.
        // long türünde bir sayıyı parametre olarak alır.

        System.out.println("limit Metodu çalışıyor...");

        list.stream()
                .limit(2L)
                .forEach(item -> System.out.println(item));


//skip : Bu metodu kullanarak akışın belli sayıda elemanını atlayabilirsiniz.
        // Bu elemanlar üzerinde işlem yapılmaz. long türünde bir sayıyı parametre olarak alır.
        System.out.println("skip Metodu çalışıyor...");

        list.stream().skip(1L)
                .limit(3L)
                .forEach(item -> System.out.println(item));

        //Burada, akışın ilk 1 elemanını atlıyor ve sonraki 3 elemanı konsola yazdırıyoruz

//count : Bu metodu kullanarak akıştaki eleman sayısını öğrenebilirsiniz. Bu metot akışı sonlandıran bir metottur,
        //yani bu metodu kullandıktan sonra akış üzerinde başka bir işlem yapamazsınız.

        System.out.println("count Metodu çalışıyor...");

        long count =list.stream()
                .filter(number -> number<5)
                .distinct()
                .count();
        //Burada, listenin içinde 5’tan küçük kaç farklı sayı olduğunu konsola yazdırıyoruz.
        // Bu kodu çalıştırırsanız konsola 1 tane yazar.
        System.out.println(count);


//anyMatch() = Elemanlardan herhangi biri bu testten geçiyorsa true, aksi halde false döndürür.
        // Bu metot akışı sonlandıran bir metottur,
        //yani bu metodu kullandıktan sonra akış üzerinde başka bir işlem yapamazsınız.

        System.out.println("anyMatch Metodu çalışıyor...");

        boolean match = list.stream()
                .anyMatch(number -> number <5);
        System.out.println(match);

        ///Burada, listenin içinde 5’ten küçük sayı olup olmadığını test ediyoruz.
        // Listede 5’ten küçük yalnızca 2 vardır; f
        // akat bu bile metodun true döndürmesi için yeterlidir.
        // Bu kodu çalıştırırsanız konsola true yazar.


//allMatch() = Elemanların tamamı bu testten geçiyorsa true, aksi halde false döndürür.
        // Bu metot akışı sonlandıran bir metottur,
        // yani bu metodu kullandıktan sonra akış üzerinde başka bir işlem yapamazsınız.
        System.out.println("allMatch Metodu çalışıyor...");

        boolean matchAll = list.stream()
                .allMatch(number -> number >1);
        System.out.println(matchAll);

        //Bu kodu çalıştırırsanız konsola true yazar;
        // çünkü listede 1’ten büyük elemanlar vardır Hepsi 1 den büyüktür
        // Eğer biri bile büyük olmasaydı false yazardı.



//noneMatch() = Elemanların hiçbiri bu testten geçmiyorsa true, aksi halde false döndürür.
        // Bu metot akışı sonlandıran bir metottur,
        // yani bu metodu kullandıktan sonra akış üzerinde başka bir işlem yapamazsınız.
        System.out.println("noneMatch Metodu çalışıyor...");

        boolean noneMatch = list.stream()
                .noneMatch(number -> number < 30);
        System.out.println(noneMatch);
        //Bu kodu çalıştırırsanız konsola false yazar; çünkü listede 30’ten küçük elemanlar vardır.


//map() = Akışın elemanlarını değiştirmek için bu metot kullanılır.
        System.out.println("map Metodu çalışıyor...");
        list.stream()
                .map(number -> number *2 )
                .forEach(number -> System.out.println(number));

        //Bu metodu kullanarak akışın içindeki elemanların türünü değiştirmek de mümkündür:
        System.out.println("map Metodu tür değiştirme çalışıyor...");
        list.stream()
                .map(number -> Math.sqrt(number))
                .forEach(number -> System.out.println(number));

        //Burada akışın türünü Integer’dan Double’a değiştiriyoruz.
----------------------------------------------------------------
ÖRNEK

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




