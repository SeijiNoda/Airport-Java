package Airport;

import ListaDeVoos.ListaDeVoos;
import Route.Route;

public class Airport {
    private String cityName;
    private int airportCode;
    private ListaDeVoos routes;

    public Airport(String name, int code) throws Exception {
        if(name == null)
            throw new Exception("No name sent!");
        if(code == 0)
            throw new Exception("Code not provided!");

        this.cityName = name;
        this.airportCode = code;
        this.routes = new ListaDeVoos();
    }

    public void setCityName(String name) throws Exception {
        if(name == null)
            throw new Exception("No name sent!");

        this.cityName = name;
    }

    public void setAirportCode(int code) throws Exception {
        if(code == 0)
            throw new Exception("Code not provided!");

        this.airportCode = code;
    }

    public String getCityName() {
        return this.cityName;
    }

    public int getAirportCode() {
        return this.airportCode;
    }

    public ListaDeVoos getRoutes() { return this.routes; }

    public void addRoute(Route newRoute) throws Exception {
        if(newRoute == null)
            throw new Exception("Route not povided!");

        routes.insereNoFim(newRoute);
    }

    public void removeRoute(int routeCode) throws Exception {
        if(routeCode == 0)
            throw new Exception("Route's code not provided!");

        routes.remova(routeCode);
    }

    public String toString() {
        String ret = "";
        ret += "Airport code: " + this.airportCode;
        ret += "\nCity: " + this.cityName;
        ret += "\nRoutes: " + this.routes;
        return ret;
    }

    public int hashCode() {
        final int PRIMO = 2;
        int ret = 314;

        ret += PRIMO * ret + new Integer(this.airportCode).hashCode();
        ret += PRIMO * ret + this.cityName.hashCode();
        ret += PRIMO * ret + this.routes.hashCode();

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

        Airport x = (Airport) other;
        if (this.airportCode != x.airportCode || this.cityName != x.cityName || !this.routes.equals(x.routes))
            return false;

        return true;
    }

    public Airport(Airport model) throws Exception {
        if(model == null)
            throw new Exception("Empty model!");

        this.airportCode = model.airportCode;
        this.cityName = model.cityName;
        this.routes = model.routes;
    }

    public Object clone() {
        Airport ret = null;
        try {
            ret = new Airport(this);
        } catch (Exception err) {}

        return ret;
    }
}
