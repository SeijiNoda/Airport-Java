package ListaDuplamenteLigadaDesordenadaSemRepeticao;

import ListaDuplamenteLigadaDesordenada.ListaDuplamenteLigadaDesordenada;

public class ListaDuplamenteLigadaDesordenadaSemRepeticao <X> extends
        ListaDuplamenteLigadaDesordenada {

    public ListaDuplamenteLigadaDesordenadaSemRepeticao() {
        super();
    }

    public void insereNoInicio(X i) throws Exception {
        if(super.tem(i))
            throw new Exception("Informacao repetida");

        super.insiraNoInicio(i);
    }

    public void insereNoFim(X i) throws Exception {
        if(super.tem(i))
            throw new Exception("Informacao repetida");

        super.insiraNoFim(i);
    }

    public ListaDuplamenteLigadaDesordenadaSemRepeticao
    (ListaDuplamenteLigadaDesordenadaSemRepeticao<X> modelo)
    throws Exception {
        super (modelo);
    }

    public Object clone() {
        ListaDuplamenteLigadaDesordenadaSemRepeticao<X> ret = null;

        try {
            ret = new ListaDuplamenteLigadaDesordenadaSemRepeticao<X>(this);
        } catch (Exception err){}

        return ret;
    }
}
