package pe.softweb.handlers;

import pe.softweb.app.App;
import pe.softweb.config.Constants;
import org.json.JSONArray;
import org.json.JSONObject;
import spark.Request;
import spark.Response;
import spark.Route;

import java.util.HashMap;
import java.util.Map;

public class MainHandler {
  public static Route index = (Request request, Response response) -> {
    Map<String, Object> model = new HashMap<>();
    JSONArray menuJSONArray = new JSONArray();
    
    JSONObject usuariosJSONObject = new JSONObject(); JSONArray usuariosJSONArrayItems = new JSONArray();
    JSONObject tempJSONObject = new JSONObject();
    tempJSONObject.put("item", "Listado"); tempJSONObject.put("url", "#/accesos/usuarios"); 
    usuariosJSONArrayItems.put(tempJSONObject);
    usuariosJSONObject.put("subtitulo", "Usuarios"); usuariosJSONObject.put("items", usuariosJSONArrayItems); 
    menuJSONArray.put(usuariosJSONObject);
    
    JSONObject sistemasJSONObject = new JSONObject(); JSONArray sistemasJSONArrayItems = new JSONArray();
    JSONObject temp0JSONObject = new JSONObject(); temp0JSONObject.put("item", "Listado"); temp0JSONObject.put("url", "#/accesos/sistemas"); 
    sistemasJSONArrayItems.put(temp0JSONObject);
    sistemasJSONObject.put("subtitulo", "Sistemas"); sistemasJSONObject.put("items", sistemasJSONArrayItems); 
    menuJSONArray.put(sistemasJSONObject);
    
    JSONObject logsJSONObject = new JSONObject(); JSONArray logsJSONArrayItems = new JSONArray();
    JSONObject temp1JSONObject = new JSONObject(); temp1JSONObject.put("item", "Errores"); temp1JSONObject.put("url", "#/log/errores"); 
    logsJSONArrayItems.put(temp1JSONObject);
    JSONObject temp2JSONObject = new JSONObject(); temp2JSONObject.put("item", "Operaciones"); temp2JSONObject.put("url", "#/log/operaciones"); 
    logsJSONArrayItems.put(temp2JSONObject);
    logsJSONObject.put("subtitulo", "Logs"); logsJSONObject.put("items", logsJSONArrayItems); 
    menuJSONArray.put(logsJSONObject);
    
    model.put("partial", "templates/home/index.vm");
    model.put("title", "Mantenimiento - Accesós");
    model.put("css", Constants.getMapita().get("STATIC_URL") + "dist/assets/mantenimiento.min.css");
    model.put("js", Constants.getMapita().get("STATIC_URL") + "dist/assets/mantenimiento.min.js"); 
    model.put("data", "");
    model.put("submenu", menuJSONArray.toString());
    return App.renderTemplate("templates/layouts/home.vm", model);
  };
}
