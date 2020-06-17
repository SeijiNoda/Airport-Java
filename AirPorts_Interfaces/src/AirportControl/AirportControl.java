package AirportControl;

import ListaDeVoos.ListaDeVoos;
import ListaDuplamenteLigadaDesordenadaSemRepeticao.ListaDuplamenteLigadaDesordenadaSemRepeticao;
import Airport.Airport;
import ListadeAerorportos.ListaDeAeroportos;
import Route.Route;

public class AirportControl {
    private ListaDeAeroportos airports;

    public AirportControl() {
        this.airports = new ListaDeAeroportos();
    }
    
    public ListaDeAeroportos getLista() {
    	return this.airports;
    }

    public void addAirport(Airport airport) throws Exception {
        if(airport == null)
            throw new Exception("No airport to insert!");

        this.airports.insereNoFim(airport);
    }

    public void addRoute(Airport airport, int cityIndex, int routeNumber) throws Exception {
        if(airport == null)
            throw new Exception("Airport not provided!");
        if(cityIndex < 0)
            throw new Exception("Destination code not provided!");
        if(routeNumber < 0)
            throw new Exception("Route number not given!");

        if(!this.airports.temAeroporto(cityIndex)){
            throw new Exception("Non existing destination airport!");
        }

        if(!this.airports.temAeroporto(airport)){
            throw new Exception("Non existing origin airport!");
        }
        
        if(airport.getAirportCode()==cityIndex)
        	throw new Exception ("Não é esperado que se tenha um voo de um aeroporto para o mesmo");

        if (this.airports.temDeterminadoVooComCodigo(routeNumber))
            throw new Exception ("There is already a route with this number!");

        airport.addRoute(new Route(cityIndex, routeNumber));
    }

    public String toString() {
        String ret = "";
        ret += this.airports.toString();
        return ret;
    }

    public int hashCode() {
        int ret = 314;
        final int PRIMO = 2;

        ret += PRIMO * ret + this.airports.hashCode();

        if(ret < 0)
            ret = -ret;

        return ret;
    }

    public boolean equals(Object other) {
        if(other == null)
            return false;
        if(this == other)
            return true;
        if(this.getClass() != other.getClass())
            return false;

        AirportControl x = (AirportControl) other;
        if(!this.airports.equals(x.airports))
            return false;

        return true;
    }

    public AirportControl(AirportControl model) throws Exception {
        if(model == null)
            throw new Exception("Empty model!");

        this.airports = model.airports;
    }

    public Object clone() {
        AirportControl ret = null;
        try {
            ret = new AirportControl(this);
        } catch (Exception err) {}

        return ret;
    }
}
