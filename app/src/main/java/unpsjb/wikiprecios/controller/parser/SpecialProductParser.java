package unpsjb.wikiprecios.controller.parser;

import org.json.JSONException;
import org.json.JSONObject;

import unpsjb.wikiprecios.model.SpecialProduct;

/**
 * Se encarga de parsear un Producto Especial de JSONObject a Entidad.
 */
public class SpecialProductParser implements Parselable {

    public SpecialProductParser() {
    }

    @Override
    public Object parse(JSONObject object) throws JSONException {
        int id = object.getInt("id");
        int idCategory = object.getInt("item_id");
        String name = object.getString("category");
        String code = object.getString("special_product_code");
        String unit = object.getString("unit");
        return new SpecialProduct(id,idCategory,name,code,unit);
    }
}
