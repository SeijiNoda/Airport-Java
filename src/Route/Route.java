package Route;

public class Route {
    private int cityIndex, routeNumber;

    public Route(int index, int nmbr) throws Exception {
        if(index == 0)
            throw new Exception("City index not provided!");
        if(nmbr == 0)
            throw new Exception("Route number not provided!");

        this.cityIndex = index;
        this.routeNumber = nmbr;
    }

    public void setCityIndex(int index) throws Exception {
        if(index < 0)
            throw new Exception("City index not provided!");

        this.cityIndex = index;
    }

    public void setRouteNumber(int nmbr) throws Exception {
        if(nmbr < 0)
            throw new Exception("Route number not provided!");

        this.routeNumber = nmbr;
    }

    public int getCityIndex() {
        return this.cityIndex;
    }

    public int getRouteNumber() {
        return this.routeNumber;
    }

    public String toString() {
        String ret = "";
        ret += "City index: " + this.cityIndex;
        ret += " Route number: " + this.routeNumber;
        return ret;
    }

    public int hashCode() {
        final int PRIMO = 2;
        int ret = 314;
        ret += PRIMO * ret + new Integer(this.cityIndex).hashCode();
        ret += PRIMO * ret + new Integer(this.routeNumber).hashCode();

        if(ret < 0)
            ret = -ret;

        return ret;
    }

    public boolean equals(Object other) {
        if(other == null)
            return false;
        if(other == this)
            return true;
        if(this.getClass() != other.getClass())
            return false;

        Route x = (Route) other;
        if(this.cityIndex != x.cityIndex || this.routeNumber != x.routeNumber)
            return false;

        return true;
    }

    public Route(Route model) throws Exception {
        if(model == null)
            throw new Exception("Empty model!");

        this.cityIndex = model.cityIndex;
        this.routeNumber = model.routeNumber;
    }

    public Object clone() {
        Route ret = null;
        try {
            ret = new Route(this);
        } catch (Exception err){}

        return ret;
    }
}
