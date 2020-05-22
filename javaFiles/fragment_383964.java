class CustomBean implements ....{
    Object obj1;
    Object obj2;
....
}

Dataset<CustomBean> changed_data = original_data.map(row->{
                return new CustomBean(obj1,obj2);
        }, Encoders.bean(CustomBean));