package at.ac.htlstp.et.sj.webserver_dynamisch.calculation;

public class RechtwinkeligesDreieck {

    // Berechnet die Hypotenuse eines rechtwinkligen Dreiecks
    public static double calculateHypotenuse(double sideA, double sideB) {
        return Math.sqrt(Math.pow(sideA, 2) + Math.pow(sideB, 2));
    }

    // Berechnet eine der Katheten eines rechtwinkligen Dreiecks
    public static double calculateSide(double hypotenuse, double knownSide) {
        return Math.sqrt(Math.pow(hypotenuse, 2) - Math.pow(knownSide, 2));
    }

}
