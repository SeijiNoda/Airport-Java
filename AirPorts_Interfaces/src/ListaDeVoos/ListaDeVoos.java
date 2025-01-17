package ListaDeVoos;

import Route.Route;
import Airport.Airport;
import ListaDuplamenteLigadaDesordenadaSemRepeticao.ListaDuplamenteLigadaDesordenadaSemRepeticao;

public class ListaDeVoos extends ListaDuplamenteLigadaDesordenadaSemRepeticao<Route> {
    public ListaDeVoos() throws Exception {
        super();
    }

    public boolean temVoo(Route other) throws Exception {
        if(other == null)
             throw new Exception("Voo n�o fornecido!");

        No atual = this.primeiro;
        Route route = null;
        while(atual != null) {
            route = (Route)atual.getInfo();
            if(other.getRouteNumber() == route.getRouteNumber()) {
                return true;
            }
            if(other.getCityIndex() == route.getCityIndex()) {
                return true;
            }

            atual = atual.getProx();
        }

        return false;
    }

    public boolean temVooComCodigo (int code) throws Exception {
        if(code < 0)
            throw new Exception("C�digo Inv�lido");

        No atual = this.primeiro;
        Route route = null;
        while (atual!=null)
        {
            route = (Route)atual.getInfo();
            if(route.getRouteNumber()==code)
                return true;

            atual = atual.getProx();
        }

        return false;
    }
    
    public int[] getAllRouteNumbersPeloCodigoAeroporto(int code) throws Exception
    {
    	if(code < 0)
    		throw new Exception("C�digo Inv�lido");
    	
    	int qtd = this.getQtd();
    	int[] arrayDeCodigos = new int[qtd];
    	
    	int i = 0;
    	No atual = this.primeiro;
        Route route = null;
        while(atual!=null)
        {
        	route = (Route) atual.getInfo();
            arrayDeCodigos[i] = route.getRouteNumber();
            
            i++;
            atual = atual.getProx();
        }
        
        return arrayDeCodigos;
    }

    @Override
    public void insereNoInicio(Route route) throws Exception {
        if(route == null)
            throw new Exception("Rota nao fornecida!");

        if(this.temVoo(route))
            throw new Exception("Rota ja existente!");

        super.insiraNoInicio(route);
    }

    @Override
    public void insereNoFim(Route route) throws Exception {
        if(route == null)
            throw new Exception("Rota nao fornecida!");

        if(this.temVoo(route))
            throw new Exception("Rota ja existente!");

        super.insiraNoFim(route);
    }

    public void remova(int code) throws Exception {
        if(code == 0)
            throw new Exception("Codigo do voo nao fornecido!");

        No atual = this.primeiro;
        Route route = null;

        while(atual != null) {
            route = (Route)atual.getInfo();
            int aleatorio = 0;
            if(code == route.getRouteNumber()) {
                this.remova(route);
                return;
            }

            atual = atual.getProx();
        }
        throw new Exception("Informacao inexistente!");
        /*if(atual == null) {
            throw new Exception("Informacao inexistente!");
        }*/
    }

    public ListaDeVoos(ListaDeVoos model) throws  Exception {
        super(model);
    }

    public Object clone() {
        ListaDeVoos ret = null;
        try {
            ret = new ListaDeVoos(this);
        } catch (Exception err) {}

        return ret;
    }
}
