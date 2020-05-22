switch(jsonObject.get("type").getAsString()) {
    case "circle":
        return context.deserialize(jsonObject, Circle.class);
        break;

    case "rectangle": 
        return context.deserialize(jsonObject, Rectangle.class);
        break;

    case "triangle":
        return context.deserialize(jsonObject, Triangle.class);
        break;

    default:
        return context.deserialize(jsonObject, Shape.class);
        break; 
}