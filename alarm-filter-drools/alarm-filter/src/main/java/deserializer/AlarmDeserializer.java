package deserializer;

import com.google.gson.*;
import com.mongodb.*;



import com.neo.drools.entity.ExtendedAlarm;

import com.google.gson.reflect.TypeToken;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;



public class AlarmDeserializer {
    public static List<ExtendedAlarm> deserializeAlarms(DBCursor cursor) {
        List<DBObject> dbObjects = new ArrayList<>();
        while (cursor.hasNext()) {
            dbObjects.add(cursor.next());
        }
    
        System.out.println("DBObjects: " + dbObjects);
    
        Gson gson = new Gson();
        String jsonString = gson.toJson(dbObjects);
        System.out.println("JSON String: " + jsonString);
    
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(Map.class, new MetadataDeserializer());
        Gson customGson = gsonBuilder.create();
    
        Type listType = new TypeToken<List<ExtendedAlarm>>() {}.getType();
        List<ExtendedAlarm> alarms = customGson.fromJson(jsonString, listType);
        System.out.println("Deserialized Alarms: " + alarms);
    
        return alarms;
    }
}

class MetadataDeserializer implements JsonDeserializer<Map<String, String>> {

    @Override
    public Map<String, String> deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
        Map<String, String> metadata = new HashMap<>();
        JsonObject jsonObject = json.getAsJsonObject();
        for (Map.Entry<String, JsonElement> entry : jsonObject.entrySet()) {
            String key = entry.getKey();
            JsonElement value = entry.getValue();
            if (value.isJsonNull()) {
                metadata.put(key, null); // Handle null values
            } else {
                metadata.put(key, value.getAsString());
            }
        }
        return metadata;
    }
}
