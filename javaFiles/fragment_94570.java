import java.util.ArrayList;
import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Mention {
    @SerializedName("allEntities")
    @Expose
    private List<AllEntity> allEntities = new ArrayList<AllEntity>();
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("bestEntity")
    @Expose
    private BestEntity bestEntity;
    public List<AllEntity> getAllEntities() {
        return allEntities;
    }
    public void setAllEntities(List<AllEntity> allEntities) {
        this.allEntities = allEntities;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    public BestEntity getBestEntity() {
        return bestEntity;
    }
    public void setBestEntity(BestEntity bestEntity) {
        this.bestEntity = bestEntity;
    }
    @Override
    public String toString() {
        return "Mention [allEntities=" + allEntities + ", name=" + name
                + ", bestEntity=" + bestEntity + "]";
    }
}