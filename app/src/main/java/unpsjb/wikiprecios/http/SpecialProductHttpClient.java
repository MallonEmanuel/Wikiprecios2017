package unpsjb.wikiprecios.http;

import android.content.Context;

import unpsjb.wikiprecios.config.Routes;
import unpsjb.wikiprecios.model.Category;
import unpsjb.wikiprecios.view.Coordinator;

/**
 * Esta clase se encarga de consultar los productos especiales de una categoria.
 */
public class SpecialProductHttpClient extends HttpClient implements HttpResponseHandler {

    private Category category;

    public SpecialProductHttpClient(Coordinator coordinator, Context context) {
        super(coordinator,context);
    }

    /**
     * Se ocupa de realizar una consulta, que permite obtener los producto especiales de
     * una categoria
     */
    public void sendRequest() {
        HttpHandler http = new HttpHandler(base_url + Routes.URL_GET_CATEGORY, HttpHandler.GET_REQUEST);
        http.addParams("item", String.valueOf(category.getId()));
        http.setListener(this);
        http.sendRequest();
        coordinator.showDialog("Obteniendo lista de productos especiales...");
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public void onSuccess(Object data) {
        coordinator.hideDialog();
        coordinator.viewSpecialProducts(data);
    }

}
