/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package BD;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.MongoClientURI;
import static com.mongodb.client.model.Filters.lt;
import java.net.UnknownHostException;
import java.util.LinkedList;

/**
 *
 * @author David
 */
public class BaseDatos {

    private DB db;

    public DB getDb() {
        return db;
    }

    public DB createConnection() throws UnknownHostException {
        MongoClient client = null;

        //String mongoCloudURI = data.getMongoURI();
        //   String mongoCloudURI = data.getMongoURILocal();
        MongoClientURI uri = new MongoClientURI("mongodb+srv://joseLuisB:Autonoma22@cluster0.s3yuf.mongodb.net/myFirstDatabase?retryWrites=true&w=majority");
        //mongodb+srv://pruebaadmin:<password>@cluster0-tlwaa.mongodb.net/test?retryWrites=true&w=majority
        System.out.println("cadena " + uri.toString());
        client = new MongoClient(uri);
        db = client.getDB("restaurante");
        return db;
    }

    public LinkedList<? extends BasicDBObject> findAll(Class<? extends BasicDBObject> clase) throws UnknownHostException {
        LinkedList<BasicDBObject> r = new LinkedList<BasicDBObject>();

        if (createConnection() != null) {
            DBCollection collection = db.getCollection(clase.getSimpleName());
            collection.setObjectClass(clase);
            DBCursor cursor = collection.find();
            while (cursor.hasNext()) {
                DBObject objectAux = cursor.next();
                r.add((BasicDBObject) objectAux);
            }
        }
        return r;
    }

    public LinkedList<? extends BasicDBObject> findEntre(Class<? extends BasicDBObject> aClass, String atribute, Number min, Number max) {
        LinkedList<BasicDBObject> r = new LinkedList<BasicDBObject>();
        BasicDBObject query = new BasicDBObject(atribute, new BasicDBObject("$gt", min).append("$lte", max));
        DBCollection collection = db.getCollection(aClass.getSimpleName());
        collection.setObjectClass(aClass);
        DBCursor cursor = collection.find(query);
        while (cursor.hasNext()) {
            DBObject objectAux = cursor.next();
            r.add((BasicDBObject) objectAux);
        }
        return r;
    }
    

    public LinkedList<? extends BasicDBObject> findNombreIgual(Class<? extends BasicDBObject> aClass, String atribute, String nombre) {
        LinkedList<BasicDBObject> r = new LinkedList<BasicDBObject>();
        BasicDBObject query = new BasicDBObject(atribute, new BasicDBObject("$eq", nombre));
        DBCollection collection = db.getCollection(aClass.getSimpleName());
        collection.setObjectClass(aClass);
        DBCursor cursor = collection.find(query);
        while (cursor.hasNext()) {
            DBObject objectAux = cursor.next();
            r.add((BasicDBObject) objectAux);
        }
        return r;
    }
        public LinkedList<? extends BasicDBObject> findValorIgual(Class<? extends BasicDBObject> aClass, String atribute, Number valor) {
        LinkedList<BasicDBObject> r = new LinkedList<BasicDBObject>();
        BasicDBObject query = new BasicDBObject(atribute, new BasicDBObject("$eq", valor));
        DBCollection collection = db.getCollection(aClass.getSimpleName());
        collection.setObjectClass(aClass);
        DBCursor cursor = collection.find(query);
        while (cursor.hasNext()) {
            DBObject objectAux = cursor.next();
            r.add((BasicDBObject) objectAux);
        }
        return r;
    }



}
