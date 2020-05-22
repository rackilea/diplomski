package com.query;

import java.util.List;

import org.openrdf.model.Graph;
import org.openrdf.model.Statement;
import org.openrdf.model.URI;
import org.openrdf.model.impl.GraphImpl;
import org.openrdf.model.impl.ValueFactoryImpl;
import org.openrdf.query.QueryEvaluationException;

import com.clarkparsia.stardog.StardogDBMS;
import com.clarkparsia.stardog.StardogException;
import com.clarkparsia.stardog.api.Connection;
import com.clarkparsia.stardog.api.ConnectionConfiguration;
import com.clarkparsia.stardog.jena.SDJenaFactory;
import com.hp.hpl.jena.query.ParameterizedSparqlString;
import com.hp.hpl.jena.query.QueryExecution;
import com.hp.hpl.jena.query.QueryExecutionFactory;
import com.hp.hpl.jena.query.ResultSet;
import com.hp.hpl.jena.query.ResultSetFormatter;
import com.hp.hpl.jena.rdf.model.Model;

public class test {
public static void main(String[] args) throws StardogException, QueryEvaluationException {
    String appDbName ="memDb";
    String selectQuery="SELECT DISTINCT ?s ?p ?o WHERE { ?s ?p  ?o }";
    StardogDBMS dbms = StardogDBMS.toServer("snarl://localhost:5820/")
            .credentials("admin", "admin".toCharArray()).login();
    List<String> dbList = (List<String>) dbms.list();
    if (dbList.contains(appDbName)) {
        System.out.println("droping " + appDbName);
        dbms.drop(appDbName);
    }
    dbms.createMemory(appDbName);
    dbms.logout();
    Connection aConn = ConnectionConfiguration
            .to("memDb")    // the name of the db to connect to
            .credentials("admin", "admin") // credentials to use while connecting
            .url("snarl://localhost:5820/")
            .connect(); 
    Model aModel = SDJenaFactory.createModel(aConn);
    System.out.println("################ GRAPH IS EMPTY B4 SUBMITTING ="+aModel.getGraph()+ "################");

    URI order = ValueFactoryImpl.getInstance().createURI("RDF:president1");
    URI givenName = ValueFactoryImpl.getInstance().createURI("RDF:lincoln");
    URI predicate = ValueFactoryImpl.getInstance().createURI("RDF:GivenNane");


    Statement aStmt = ValueFactoryImpl.getInstance().createStatement(order,predicate,givenName);
    Graph aGraph = new GraphImpl();
    aGraph.add(aStmt);
    insert(aConn, aGraph);


    ParameterizedSparqlString paraQuery = new ParameterizedSparqlString(selectQuery);
    QueryExecution qExecution = QueryExecutionFactory.create(paraQuery.asQuery(),aModel);
    ResultSet queryResult = qExecution.execSelect();
    System.out.println("############### 1 TUPPLE CAME AFTER INSERT ################");
    ResultSetFormatter.out(System.out, queryResult);

    aGraph.add(aStmt);
    remove(aConn, aGraph);


    paraQuery = new ParameterizedSparqlString(selectQuery);
    qExecution = QueryExecutionFactory.create(paraQuery.asQuery(),aModel);
    queryResult = qExecution.execSelect();
    System.out.println("################ DB AGAIN EMPTY AFTER REMOVE ################");
    ResultSetFormatter.out(System.out, queryResult);


    System.out.println("closing connection and model");
    aModel.close();
    aConn.close();  
}
private static void insert(final Connection theConn, final Graph theGraph) throws StardogException {
    theConn.begin();
    theConn.add().graph(theGraph);
    theConn.commit();
}

private static void remove(final Connection theConn, final Graph theGraph) throws StardogException {
    theConn.begin();
    theConn.remove().graph(theGraph);
    theConn.commit();
}
}