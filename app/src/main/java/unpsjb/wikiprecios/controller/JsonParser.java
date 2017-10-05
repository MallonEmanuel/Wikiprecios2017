package unpsjb.wikiprecios.controller;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by emanuel on 29/09/17.
 * permite pasrsear una lista de objetos Json
 */
public class JsonParser {

    public static List getList(Parseable p, JSONArray json) throws JSONException {
        List lst = new ArrayList<>();

        for (int n = 0; n < json.length(); n++) {
            JSONObject object = json.getJSONObject(n);
            lst.add(p.parse(object));
        }
        return lst;
    }

    public static JSONArray parseToJSONArray(Object data) throws JSONException {
        JSONArray json = null;
        json = new JSONArray(data.toString());
        return json;
    }

}
