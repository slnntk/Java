package beecrowd.exerciciosResolvidos;

import java.util.Scanner;

public class D1961 {
    public static void main(String[] args) {
        new PulaSapo();
    }
}

class PulaSapo{

    public PulaSapo() {
        Scanner sc = new Scanner(System.in);
        Sapo s = new Sapo(sc.nextInt(), sc);
        gameFinish(pularCanos(s.getSaltoMax(), sc));
    }

    public void result(String result){
        System.out.println(result);
    }

    public void gameFinish(boolean jumping){
        String temp = "";
        if (jumping){
            temp = "YOU WIN";
        }
        else{
            temp = "GAME OVER";
        }
        result(temp);
    }

    public boolean pularCanos(int puloSapo, Scanner sc){
        int n = sc.nextInt();
        boolean jumping = true;
        for (int i = 0;i < n;i++){
            Cano c = new Cano(sc.nextInt());
            if (canJump(c.getAltura(), puloSapo)){
                jumping = true;
            }
            else{
                jumping = false;
            }
        }
        return jumping;
    }

    public boolean canJump(int cano, int sapo){
        if (sapo >= cano && cano > 1){
            return true;
        }
        else{
            return false;
        }
    }

}

class Sapo{

    private int saltoMax;

    public Sapo(int saltoMax, Scanner sc) {
        this.saltoMax = saltoMax;
    }

    public int getSaltoMax() {
        return saltoMax;
    }

}

class Cano{

    private int altura;

    public Cano(int altura) {
        this.altura = altura;
    }

    public int getAltura() {
        return altura;
    }
}
