package Programa;

import ListaDuplamenteLigadaDesordenada.ListaDuplamenteLigadaDesordenada;
import ListaDuplamenteLigadaDesordenadaSemRepeticao.ListaDuplamenteLigadaDesordenadaSemRepeticao;

public class Programa {
    public static void main(String[] args){
        try {
            ListaDuplamenteLigadaDesordenada<String> lista1 = new ListaDuplamenteLigadaDesordenada<String>();
            String val = "oi";
            lista1.insiraNoInicio( val);
            lista1.insiraNoInicio( new String("ola"));
            lista1.insiraNoInicio( new String("hello"));
            lista1.insiraNoInicio( new String("ciao"));
            System.out.println(lista1);
            ListaDuplamenteLigadaDesordenada lista2 = lista1.inversao();
            //lista1.invertaSe();
            System.out.println(lista2);

            ListaDuplamenteLigadaDesordenadaSemRepeticao<String> lista3 = new ListaDuplamenteLigadaDesordenadaSemRepeticao<String>();
            //lista3.insereNoInicio(val);
            lista3.insereNoInicio(new String("oi"));
            System.out.println("Lista 3: " + lista3);

        } catch (Exception err){
            err.printStackTrace();
        }
    }
}
