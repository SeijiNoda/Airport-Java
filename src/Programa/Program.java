package Programa;

import Airport.Airport;
import Route.Route;
import AirportControl.AirportControl;

public class Program {
    public static void main(String[] args) {
        try {
            System.out.println("Teste de Aerorporto\n");

            Airport ap1 = new Airport("Campinas", 1);
            Airport ap2 = new Airport("Sao Paulo", 2);
            Airport ap3 = new Airport("Belo Horizonte", 3);

            AirportControl apCont1 = new AirportControl();
                apCont1.addAirport(ap1);
                apCont1.addAirport(ap2);
                apCont1.addAirport(ap3);

                apCont1.addRoute(ap1, 3, 2);
                apCont1.addRoute(ap1, 2, 1);

            System.out.println(ap1);

            System.out.println("\nTeste do controller\n");

                apCont1.addRoute(ap2, 3, 1);
                apCont1.addRoute(ap2, 1, 2);

                apCont1.addRoute(ap3, 1,3);
                apCont1.addRoute(ap3, 2,4);

            System.out.println(apCont1);
        } catch(Exception err) {
            err.printStackTrace();
        }
    }
}
