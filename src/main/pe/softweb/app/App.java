package pe.softweb.app;
import com.j256.ormlite.dao.Dao;
import com.j256.ormlite.dao.DaoManager;
import com.j256.ormlite.stmt.PreparedQuery;
import com.j256.ormlite.stmt.QueryBuilder;
import com.j256.ormlite.support.ConnectionSource;
import org.json.JSONObject;
import pe.softweb.models.Sistema;
import pe.softweb.config.Database;
import java.util.ArrayList;
import java.util.List;

public class App {

	public static void main(String[] args) {
		String rpta = "";
		System.out.println("Hola mundo");
		try {
            Database conexion = new Database();
            ConnectionSource connectionSource = conexion.getConnectionSource();

            List<JSONObject> rptaTemp = new ArrayList<JSONObject>();
            Dao<Sistema, String> sistemaDao = DaoManager.createDao(connectionSource, Sistema.class);
            QueryBuilder<Sistema, String> queryBuilder = sistemaDao.queryBuilder();
            PreparedQuery<Sistema> preparedQuery = queryBuilder.prepare();
            List<Sistema> sistemaList = sistemaDao.query(preparedQuery);

            for (Sistema sistema : sistemaList) {
                JSONObject obj = new JSONObject();
                obj.put("id", sistema.getId());
                obj.put("nombre", sistema.getNombre());
                obj.put("version", sistema.getVersion());
                obj.put("repositorio", sistema.getRepositorio());
                rptaTemp.add(obj);
            }

            rpta = rptaTemp.toString();
            System.out.println(rpta);
        } catch (Exception e) {
            //e.printStackTrace();
            JSONObject rptaTry = new JSONObject();
            rptaTry.put("tipo_mensaje", "error");
            String[] error = {"Se ha producido un error en  listar los sistemas registrado", e.toString()};
            rptaTry.put("mensaje", error);
            System.out.println( rptaTry.toString());
        }
	}

}
