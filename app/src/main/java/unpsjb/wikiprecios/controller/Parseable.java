package unpsjb.wikiprecios.controller;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;

/**
 * Created by emanuel on 29/09/17.
 * Permite a quien lo implemente crear un objeto a partir del JsonObject recibido
 */
public interface Parseable extends Serializable{
    Object parse(JSONObject object) throws JSONException;
}
