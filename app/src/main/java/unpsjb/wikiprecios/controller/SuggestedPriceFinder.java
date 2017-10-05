package unpsjb.wikiprecios.controller;

import android.content.Context;

import unpsjb.wikiprecios.config.Routes;
import unpsjb.wikiprecios.model.Commerce;
import unpsjb.wikiprecios.model.Query;
import unpsjb.wikiprecios.view.Coordinator;
import unpsjb.wikiprecios.view.util.Message;

/**
 * Created by emanuel on 05/10/17.
 */
public class SuggestedPriceFinder extends Finder implements HttpResponseHandler {

    private Query query;

    public SuggestedPriceFinder(Coordinator coordinator, Context context) {
        super(coordinator, context);
    }

    public void sendRequest() {
        HttpHandler http = new HttpHandler(base_url + Routes.URL_SUGGESTED_PRICE, HttpHandler.GET_REQUEST);
        Commerce commerce = query.getCommerce();
        http.addParams("commerce", String.valueOf(commerce.getId()));
        http.addParams("product", query.getBarcode());
        http.setListener(this);
        http.sendRequest();

    }

    @Override
    public void onSuccess(Object data) {
        // TODO Si existen precios sugeridos mostrarlos..
        Message.show(context,data.toString());
        coordinator.viewPrice();
    }

    public void setQuery(Query query) {
        this.query = query;
    }
}
