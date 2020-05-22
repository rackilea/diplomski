<?php
import com.google.appengine.api.datastore;
import com.google.appengine.api.datastore.Entity;
import com.google.appengine.api.datastore.DatastoreServiceFactory;
import com.google.appengine.api.datastore.Text;


$entity = new Entity("test"); 
$TextValue = new Text(' --- more than 500 char ---');
$entity->setProperty('story',$TextValue);
$dataService = DatastoreServiceFactory::getDatastoreService();
$dataService->put($entity);
?>