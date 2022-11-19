package Classes;

import org.neo4j.driver.AuthTokens;
import org.neo4j.driver.Driver;
import org.neo4j.driver.GraphDatabase;
import org.neo4j.driver.Result;
import org.neo4j.driver.Session;
import org.neo4j.driver.SessionConfig;
import org.neo4j.driver.exceptions.NoSuchRecordException;

/**
 *
 * @author Pedro
 */
public class Neo4JConnect {
    
    private final String DATABASE_NAME = "binarydiary";
    private final String DB_URL = "bolt://localhost:11003";
    private final String USER = "neo4j";
    private final String PASSWORD = "walter";
    private Session session;
    private Driver databaseDriver;
    
    public void connect(){
        databaseDriver = GraphDatabase.driver(DB_URL, AuthTokens.basic(USER, PASSWORD));
        session = databaseDriver.session(SessionConfig.forDatabase(DATABASE_NAME));
    }
    
    public Result QueryExecutor(String query){
        return session.run(query);
    }   
    
    public void closeConnection(){
        session.close();
        databaseDriver.close();
    }
    
    public String getServerName(){
        try{
            return QueryExecutor("call db.info()").single().get(1).asString();
        }
        catch(NoSuchRecordException e){
        }
        return "ERROR";
    }
}
