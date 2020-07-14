package server;

import java.util.Collection;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;


public class WebsocketMapUtil {

    public static ConcurrentMap<String, WebsocketServer> webSocketMap = new ConcurrentHashMap<>();

    public static void put(String key, WebsocketServer myWebSocketServer){
        webSocketMap.put(key, myWebSocketServer);
    }

    public static WebsocketServer get(String key){
        return webSocketMap.get(key);
    }

    public static void remove(String key){
        webSocketMap.remove(key);
    }

    public static Collection<WebsocketServer> getValues(){
        return webSocketMap.values();
    }
}
