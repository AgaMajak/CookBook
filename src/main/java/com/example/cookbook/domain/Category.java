package com.example.cookbook.domain;

public enum Category {
   STARTER("Przystawka", "Przekąska przed obiadem", "https://static.gotujmy.pl/ZDJECIE_PRZEPISU_M/biedronkowa-przystawka-266712.jpg"),
    SOUP("Zupa", "Pierwsze danie","https://inspirowanesmakiem.pl/wp-content/uploads/2019/02/zupa-krem-930x530.jpg"),
    MAIN("Danie główne","Najważniejszy element obiadu", "https://zmwarmia.pl/wp-content/uploads/2018/04/roladki-z-wo%C5%82owiny-4-800x534.jpg"),
    DESSERT("Deser", "Coś słodkiego po obiedzie", "https://pysznosci.pl/wp-content/uploads/2020/03/deser-neapolitanskivlcsnap-2020-03-09-13h35m06s924.jpg.webp"),
    DRINK("Napój", "Coś do popicia", "https://www.krainawody.pl/modules/ph_simpleblog/featured/56.jpg"),
    BAKING("Wypiek", "Słodki lub słony, zależnie od gustu", "https://obcasy.pl/wp-content/uploads/2019/04/nutella-wypieki.jpg");

    Category(String name, String description, String imgUrl) {
        this.name = name;
        this.description = description;
        this.imgUrl = imgUrl;
    }

    private final String name;
   private final String description;
   private final String imgUrl;

}
