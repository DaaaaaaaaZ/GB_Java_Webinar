package dz.geekbrains.java.lesson7;

public class Cat {
    private String name = "Кот";
    private int appetite = 5;
    private boolean hungry = true;

    public Cat(String name, int appetite) {
        if (name != null && !name.isEmpty()) {
            this.name = name;
        }

        if (appetite > 0) {
            this.appetite = appetite;
        }
    }

    public void setHungry (boolean hungry) {
        if (hungry) {
            if (this.hungry) {
                System.out.println(name + " так голоден, что готов съесть лошадь.");
            } else {
                this.hungry = true;
                System.out.println("Кажется " + name + " проголодался. Готовьте миски с едой.");
            }
        } else if (this.hungry) { //hungry == false && this.hungry == true
            System.out.println(name + " может победить голод только едой.");
        } else { //hungry == false && this.hungry == false
            System.out.println(name + " ещё не нагулял аппетит.");
        }
    }

    public void eat (Plate plate) {
        if (plate == null) {
            System.out.println(name + " говорит: \"Мяу, где моя миска?\".");
        } else if (hungry) {
            if (plate.decreaseFood(appetite)) {
                hungry = false;
                System.out.println(name + " покушал, " + name + " доволен.");
            } else if (plate.getFood() == 0) {
                System.out.println(name + " говорит, что миска уже была пуста до него и ему надо верить.");
            } else {
                System.out.println(name + " не станет мараться о такое мизерное количество еды. " +
                        "Необходимо пополнить баланс ... т.е. миску.");
            }
        } else {
            System.out.println(name + " не хочет есть. Он лучше пойдёт, погуляет.");
        }
    }

    public void info () {
        if (hungry) {
            System.out.println(name + " хочет есть. Необходимо покормить кота.");
        } else {
            System.out.println(name + " сыт и доволен жизьню.");
        }
    }
}
