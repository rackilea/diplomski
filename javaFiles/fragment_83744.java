-----------------------------------com.app.Context.java-----------------------------------

    package com.app;

    import javax.annotation.Generated;
    import com.google.gson.annotations.Expose;
    import com.google.gson.annotations.SerializedName;

    @Generated("org.jsonschema2pojo")
    public class Context {

        @SerializedName("context")
        @Expose
        public Context_ context;
        @SerializedName("id")
        @Expose
        public String id;

    }
    -----------------------------------com.app.Context_.java-----------------------------------

    package com.app;

    import javax.annotation.Generated;
    import com.google.gson.annotations.Expose;
    import com.google.gson.annotations.SerializedName;

    @Generated("org.jsonschema2pojo")
    public class Context_ {

        @SerializedName("mutual_friends")
        @Expose
        public MutualFriends mutualFriends;
        @SerializedName("id")
        @Expose
        public String id;

    }
    -----------------------------------com.app.Cursors.java-----------------------------------

    package com.app;

    import javax.annotation.Generated;
    import com.google.gson.annotations.Expose;
    import com.google.gson.annotations.SerializedName;

    @Generated("org.jsonschema2pojo")
    public class Cursors {

        @SerializedName("before")
        @Expose
        public String before;
        @SerializedName("after")
        @Expose
        public String after;

    }
    -----------------------------------com.app.Datum.java-----------------------------------

    package com.app;

    import javax.annotation.Generated;
    import com.google.gson.annotations.Expose;
    import com.google.gson.annotations.SerializedName;

    @Generated("org.jsonschema2pojo")
    public class Datum {

        @SerializedName("name")
        @Expose
        public String name;
        @SerializedName("id")
        @Expose
        public String id;

    }
    -----------------------------------com.app.MutualFriends.java-----------------------------------

    package com.app;

    import java.util.ArrayList;
    import java.util.List;
    import javax.annotation.Generated;
    import com.google.gson.annotations.Expose;
    import com.google.gson.annotations.SerializedName;

    @Generated("org.jsonschema2pojo")
    public class MutualFriends {

        @SerializedName("data")
        @Expose
        public List<Datum> data = new ArrayList<Datum>();
        @SerializedName("paging")
        @Expose
        public Paging paging;
        @SerializedName("summary")
        @Expose
        public Summary summary;

    }
    -----------------------------------com.app.Paging.java-----------------------------------

    package com.app;

    import javax.annotation.Generated;
    import com.google.gson.annotations.Expose;
    import com.google.gson.annotations.SerializedName;

    @Generated("org.jsonschema2pojo")
    public class Paging {

        @SerializedName("cursors")
        @Expose
        public Cursors cursors;

    }
    -----------------------------------com.app.Summary.java-----------------------------------

    package com.app;

    import javax.annotation.Generated;
    import com.google.gson.annotations.Expose;
    import com.google.gson.annotations.SerializedName;

    @Generated("org.jsonschema2pojo")
    public class Summary {

        @SerializedName("total_count")
        @Expose
        public Integer totalCount;

    }