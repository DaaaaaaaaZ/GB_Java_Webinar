package dz.geekbrains.java.lesson7;

public class Plate {
    private int food = 0;

    public Plate(int food) {
        if (food > 0) {
            this.food = food;
        }
    }

    //Допустим, что миски у нас равны по вместимости int
    public boolean increaseFood (int amountFood) {
        if ((Integer.MAX_VALUE - food) < amountFood) {
            System.out.println("В миску столько не положишь.");
            return false;
        } else if (amountFood > 0) {
            food += amountFood;
            return true;
        }
        return false;
    }

    public boolean decreaseFood (int amountFood) {
        if (food > amountFood) {
            food -= amountFood;
            return true;
        } else if (food == 0) {
            //System.out.println("Миска пуста.");
            return false;
        } else { //Если еды недостаточно, то ничего не трогаем
            //System.out.println("В миске нет столько еды!");
            return false;
        }
    }

    public int getFood () {
        return food;
    }
}
