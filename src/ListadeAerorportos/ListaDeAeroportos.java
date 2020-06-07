package ListadeAerorportos;

import Airport.Airport;
import ListaDuplamenteLigadaDesordenadaSemRepeticao.ListaDuplamenteLigadaDesordenadaSemRepeticao;

public class ListaDeAeroportos extends ListaDuplamenteLigadaDesordenadaSemRepeticao<Airport> {
    public ListaDeAeroportos() throws Exception {
        super();
    }

    public boolean temAeroporto(Airport airport) throws Exception {
        if(airport == null)
            throw new Exception("Aeroporto nao fornecido!");

        No atual = this.primeiro;
        Airport other = null;
        while(atual != null) {
            other = (Airport) atual.getInfo();
            if(airport.getAirportCode() == other.getAirportCode())
                return true;
            if(airport.getCityName().equals(other.getCityName()))
                return true;

            atual = atual.getProx();
        }

        return false;
    }

    public boolean temAeroporto(int code) throws Exception {
        if(code == 0)
            throw new  Exception("Codigo nao fornecido!");

        No atual = this.primeiro;
        Airport other = null;
        while(atual != null) {
            other = (Airport) atual.getInfo();
            if(code == other.getAirportCode())
                return true;

            atual = atual.getProx();
        }

        return false;
    }

    @Override
    public void insereNoInicio(Airport airport) throws Exception {
        if(airport == null)
            throw new Exception("Aeroporto nao fornecido!");

        if(temAeroporto(airport))
            throw new Exception("Aerorporto repetido!");

        super.insiraNoInicio(airport);
    }

    @Override
    public void insereNoFim(Airport airport) throws Exception {
        if(airport == null)
            throw new Exception("Aeroporto nao fornecido!");

        if(temAeroporto(airport))
            throw new Exception("Aeroporto repetido!");

        super.insiraNoFim(airport);
    }

    @Override
    public String toString() {
        String ret = "[\n";

        No atual=this.primeiro;

        while(atual!=null) {
            ret = ret + atual.getInfo();

            if(atual != this.ultimo)
                ret = ret + ",\n";

            atual=atual.getProx();
        }

        return ret+"\n]";
    }

    public ListaDeAeroportos(ListaDeAeroportos model) throws Exception{
        super(model);
    }

    public Object clone() {
        ListaDeAeroportos ret = null;
        try {
            ret = new ListaDeAeroportos(this);
        } catch (Exception err) {}

        return ret;
    }
}
