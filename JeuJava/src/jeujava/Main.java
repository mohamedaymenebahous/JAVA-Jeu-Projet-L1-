package jeujava;

import jeujava.Plateau2;

public class Main {
    
    public static void main(String[] args) {
        Indice i1 = new Indice();
        Indice i2 = new Indice();
        IndiceSomme idS = new IndiceSomme();
        IndiceProduit idP = new IndiceProduit();
        IndiceSoust idSt = new IndiceSoust();
        IndiceSup idSp = new IndiceSup();
        IndiceInf idInf = new IndiceInf();
        LesJoueurs lj = new LesJoueurs();
        Plateau2 p = new Plateau2(i1, i2, idS, idP, idSt, idSp, idInf);
        NewClass j = new NewClass(p, lj);
        j.initJeu();

    }

}

/*

Plateau p = new Plateau(i1, i2, idS, idP, idSt, idSp, idInf);
        Jeu j = new Jeu(p, lj);



*/