package dz.geekbrains.java.lesson7;

public class Main {
    public static void main(String[] args) {
        Plate plate1 = new Plate (100);
        Plate plate2 = new Plate (5);
        Plate plate3 = new Plate (0);
        Plate plate4 = new Plate (Integer.MAX_VALUE - 2);

        Cat cat1 = new Cat ("Константин Иваныч", 18);
        Cat cat2 = new Cat ("Мурзик", 4);

        //plate4.increaseFood(100);
        //System.out.println(plate4.getFood());

        System.out.println("\tКормим Иваныча:");
        cat1.eat (null);
        cat1.eat (plate2);
        cat1.eat (plate3);
        cat1.eat (plate1);

        System.out.println();
        System.out.println("\tТестируем Мурзика:");
        cat2.setHungry(false);
        cat2.setHungry(true);
        cat2.eat (plate1);
        cat2.eat (plate1);
        cat2.setHungry(false);
        cat2.setHungry(true);
        cat2.eat(plate4);

        //Пункт 5 из задания
        System.out.println();
        System.out.println("\tВыполняем 5-е задание:");
        Cat [] cats = {
                new Cat ("Барсик", 7),
                new Cat ("Тузик", 3),
                new Cat ("Масик", 12)
        };

        for (Cat c : cats) {
            c.info();
        }

        cats [0].eat(plate1);
        cats [1].eat(plate1);
        cats [2].eat(plate1);

        for (Cat c : cats) {
            c.info();
        }

        //Пункт 6
        System.out.println();
        System.out.println("\tВыполняем 6-е задание:");
        Cat catX = new Cat ("Вениаминыч", 9);
        System.out.println("В plate3 сейчас " + plate3.getFood() +
                " еды. Пробуем накормить голодного кота из неё:");
        catX.eat(plate3);
        plate3.increaseFood(99);
        System.out.println("Положили в plate3 99 еды. Попросим прощения у кота:");
        catX.eat(plate3);


    }
}
