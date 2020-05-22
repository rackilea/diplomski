// https://helpx.adobe.com/experience-manager/6-4/sites/developing/using/reference-materials/javadoc/com/day/cq/dam/api/collection/SmartCollection.html
import com.day.cq.dam.api.collection.SmartCollection;
import com.day.cq.dam.api.Asset;
def SMART_COLLECTION_PATH = "/content/dam/collections/J/Jx4h69ABp_KoLbZJ-8dq/test-collection";
def smartCollectionResource = getResource(SMART_COLLECTION_PATH)
def smartCollection = smartCollectionResource.adaptTo(SmartCollection.class)

smartCollection
.getQuery()
.getResult()
.getNodes()
.each {
    def assetResource = getResource(it.path);
    def asset = assetResource.adaptTo(Asset.class)
    println asset.path
}